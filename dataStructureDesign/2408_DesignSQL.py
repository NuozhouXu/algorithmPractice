class SQL:

    def __init__(self, names: List[str], columns: List[int]):
        # Store table metadata: name -> number of columns
        self.table_columns = {}
        # Store table data: name -> {rowId: row_data}
        self.tables = {}
        # Track next row ID for each table: name -> next_id
        self.next_id = {}
        
        for i in range(len(names)):
            table_name = names[i]
            num_columns = columns[i]
            
            self.table_columns[table_name] = num_columns
            self.tables[table_name] = {}
            self.next_id[table_name] = 1

    def ins(self, name: str, row: List[str]) -> bool:
        # Check if table exists
        if name not in self.table_columns:
            return False
        
        # Check if row length matches expected columns
        if len(row) != self.table_columns[name]:
            return False
        
        # Insert the row with auto-incremented ID
        row_id = self.next_id[name]
        self.tables[name][row_id] = row
        self.next_id[name] += 1
        
        return True

    def rmv(self, name: str, rowId: int) -> None:
        # Check if table exists
        if name not in self.tables:
            return
        
        # Remove the row if it exists
        if rowId in self.tables[name]:
            del self.tables[name][rowId]

    def sel(self, name: str, rowId: int, columnId: int) -> str:
        # Check if table exists
        if name not in self.tables:
            return "<null>"
        
        # Check if row exists
        if rowId not in self.tables[name]:
            return "<null>"
        
        # Check if column is valid (1-indexed)
        row = self.tables[name][rowId]
        if columnId < 1 or columnId > len(row):
            return "<null>"
        
        # Return the value (columnId is 1-indexed)
        return row[columnId - 1]

    def exp(self, name: str) -> List[str]:
        # Check if table exists
        if name not in self.tables:
            return []
        
        # Build CSV format for each row
        result = []
        # Get all row IDs and sort them
        row_ids = sorted(self.tables[name].keys())
        
        for row_id in row_ids:
            row = self.tables[name][row_id]
            # Format: "id,value1,value2,..."
            csv_row = str(row_id) + "," + ",".join(row)
            result.append(csv_row)
        
        return result
class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        
        # Helper function to get board coordinates from square label
        def get_position(square):
            # square is 1-indexed, convert to 0-indexed
            square -= 1
            row = n - 1 - (square // n)  # rows go from bottom to top
            col = square % n
            
            # Check if this row goes right-to-left (even rows from bottom are reversed)
            # Bottom row (n-1) is row 0 in terms of counting from bottom
            row_from_bottom = n - 1 - row
            if row_from_bottom % 2 == 1:  # odd rows from bottom go right-to-left
                col = n - 1 - col
                
            return (row, col)
        
        # BFS
        queue = deque([1])  # start at square 1
        visited = {1}
        moves = 0
        target = n * n
        
        while queue:
            size = len(queue)
            
            for _ in range(size):
                curr = queue.popleft()
                
                # Check if we reached the end
                if curr == target:
                    return moves
                
                # Try all possible dice rolls (1-6)
                for dice in range(1, 7):
                    next_square = curr + dice
                    
                    # Can't go beyond the board
                    if next_square > target:
                        break
                    
                    # Get the board position
                    row, col = get_position(next_square)
                    
                    # Check if there's a snake or ladder
                    if board[row][col] != -1:
                        next_square = board[row][col]
                    
                    # Only visit if not visited before
                    if next_square not in visited:
                        visited.add(next_square)
                        queue.append(next_square)
            
            moves += 1
        
        # If we exit the loop without finding the target
        return -1
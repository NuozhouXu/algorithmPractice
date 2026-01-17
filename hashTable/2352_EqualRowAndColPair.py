class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        count = 0
        row_counter = collections.Counter(tuple(row) for row in grid)
        for j in range(len(grid)):
            col = []
            for i in range(len(grid)):
                col.append(grid[i][j])
            count += row_counter[tuple(col)]
        return count

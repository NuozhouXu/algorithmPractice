class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        maxLocal = [[0] * (n - 2) for _ in range(n - 2)]
        
        for i in range(n - 2):
            for j in range(n - 2):
                # Find max in 3x3 submatrix starting at (i, j)
                max_val = 0
                for row in range(i, i + 3):
                    for col in range(j, j + 3):
                        max_val = max(max_val, grid[row][col])
                maxLocal[i][j] = max_val
        
        return maxLocal
class Solution {
    // O(m^2 * n^2)
    public int minDays(int[][] grid) {
        int[][] copy = copyGrid(grid);
        int num = numIslands(copy);
        if (num > 1) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy = copyGrid(grid);
                if (copy[i][j] == 1) {
                    copy[i][j] = 0;
                    num = numIslands(copy);
                    if (num > 1) return 1;
                }
            }
        }
        return 2;
    }
    
    public int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
    
    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        int result = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    result++;
                    grid[row][col] = 0;
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.add(row * numCols + col);
                    while (!queue.isEmpty()) {
                        Integer cellId = queue.pollFirst();
                        int r = cellId / numCols;
                        int c = cellId % numCols;
                        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                            queue.add((r - 1) * numCols + c);
                            grid[r - 1][c] = 0;
                        }
                        if (r + 1 < numRows && grid[r + 1][c] == 1) {
                            queue.add((r + 1) * numCols + c);
                            grid[r + 1][c] = 0;
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                            queue.add(r * numCols + c - 1);
                            grid[r][c - 1] = 0;
                        }
                        if (c + 1 < numCols && grid[r][c + 1] == 1) {
                            queue.add(r * numCols + c + 1);
                            grid[r][c + 1] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
}
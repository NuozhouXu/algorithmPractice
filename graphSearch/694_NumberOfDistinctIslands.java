class Solution {
    
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    // O(mn) time
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> uniqueShapes = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j);
                    uniqueShapes.add(sb.toString());
                }
            }
        }
        return uniqueShapes.size();
    }
    
    private void dfs(int[][] grid, StringBuilder sb, int row, int col) {
        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 0;
                sb.append(i);
                dfs(grid, sb, newRow, newCol);
            }
        }
        sb.append("b");
    }
}
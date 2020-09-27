class Solution {
    // O(3^N) where N is the number of cells in grid.
    private static final int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] numUniquePaths = new int[1];
        boolean[][] visited = new boolean[m][n];
        int[] start = new int[2];
        int[] end = new int[2];
        int numZeroes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    visited[start[0]][start[1]] = true;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 0) {
                    numZeroes++;
                }
            }
        }
        dfs(grid, visited, start, end, numZeroes, numUniquePaths, 0);
        return numUniquePaths[0];
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int[] curr, int[] end, int numZeroes, int[] numUniquePaths, int dist) {
        if (curr[0] == end[0] && curr[1] == end[1]) {
            if (dist == numZeroes + 1) {
                numUniquePaths[0]++;
            }
            return;
        }
        
        for (int[] dir: dirs) {
            int newRow = curr[0] + dir[0];
            int newCol = curr[1] + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
               !visited[newRow][newCol] && grid[newRow][newCol] != -1) {
                visited[newRow][newCol] = true;
                dfs(grid, visited, new int[]{newRow, newCol}, end, numZeroes, numUniquePaths, dist + 1);
                visited[newRow][newCol] = false;
            }
        }
    }
}
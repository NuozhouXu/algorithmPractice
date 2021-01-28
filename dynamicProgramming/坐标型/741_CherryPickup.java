class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        return Math.max(helper(grid, n - 1, n - 1, n - 1, dp), 0);
    }
    
    private int helper(int[][] grid, int x1, int y1, int x2, int[][][] dp) {
        int y2 = x1 + y1 - x2;
        if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) return -1;
        if (grid[x1][y1] < 0 || grid[x2][y2] < 0) return -1;
        if (x1 == 0 && y1 == 0) return grid[0][0];
        if (dp[x1][y1][x2] != Integer.MIN_VALUE) return dp[x1][y1][x2];
        int ans = Integer.MIN_VALUE;
        ans = Math.max(Math.max(helper(grid, x1 - 1, y1, x2 - 1, dp), helper(grid, x1 - 1, y1, x2, dp)),
                      Math.max(helper(grid, x1, y1 - 1, x2, dp), helper(grid, x1, y1 - 1, x2 - 1, dp)));
        if (ans < 0) {
            dp[x1][y1][x2] = -1;
            return -1;
        }
        ans += grid[x1][y1];
        if (x1 != x2) ans += grid[x2][y2];
        dp[x1][y1][x2] = ans;
        return ans;
    }
}
class Solution {
    public int uniquePathsTopDown(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePathsHelper(m, n, dp);
    }
    
    private int uniquePathsHelper(int m, int n, int[][] dp) {
        if (m == 1 || n == 1) {
            dp[m - 1][n - 1] = 1;
            return 1;
        }
        if (dp[m - 1][n - 1] != 0) {
            return dp[m - 1][n - 1];
        } else {
            int numPaths = uniquePathsHelper(m - 1, n, dp) + uniquePathsHelper(m, n - 1, dp);
            dp[m - 1][n - 1] = numPaths;
            return numPaths;
        }
    }

    public int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i <= m; i++) {
            dp[i - 1][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i - 1] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
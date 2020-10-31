class Solution {
    public int maxDotProduct(int[] A, int[] B) {
        int n = A.length, m = B.length, dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = A[i] * B[j];
                if (i > 0 && j > 0) dp[i][j] += Math.max(dp[i-1][j-1], 0);
                if (i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        return dp[n-1][m-1];
    }
}
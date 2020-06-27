class Solution {
    // O(n^3) time O(n^2) space
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                int minVal = Integer.MAX_VALUE;
                for (int i = start; i < end; i++) {
                    minVal = Math.min(minVal, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
                }
                dp[start][end] = minVal;
            }
        }
        return dp[1][n];
    }
}
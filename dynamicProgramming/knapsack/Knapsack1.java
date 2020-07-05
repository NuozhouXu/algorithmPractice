public class Solution {
    public int knapsack1(int[] weights, int limit) {
        boolean[][] dp = new boolean[weights.length + 1][limit + 1];
        int maxSize = 0;
        for (int i = 0; i <= weights.length; i++) dp[i][0] = true;
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= limit; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weights[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - weights[i - 1]];
                }
                if (dp[i][j]) {
                    maxSize = Math.max(maxSize, j);
                }
            }
        }
        return maxSize;
    }
}
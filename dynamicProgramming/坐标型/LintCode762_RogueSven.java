public class Solution {
    /**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    // O(mn^2) time O(mn) space
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // 
        long[][] dp = new long[n + 1][m + 1];
        dp[0][m] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    if (i - k <= limit && j + cost[i] <= m) {
                        dp[i][j] += dp[k][j + cost[i]];
                    }
                }
            }
        }
        long numWays = 0;
        for (int i = 0; i <= m; i++) {
            numWays += dp[n][i];
        }
        return numWays;
    }

    // O(mn) time O(mn) space
    public long getNumberOfWaysOptimized(int n, int m, int limit, int[] cost) {
        // 
        long[][] dp = new long[n + 1][m + 1];
        long[][] sum = new long[n + 1][m + 1];
        dp[0][m] = 1;
        sum[0][m] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                sum[i][j] = sum[i - 1][j];
                if (j + cost[i] <= m) {
                    dp[i][j] = sum[i - 1][j + cost[i]];
                    if (i - limit - 1 >= 0) {
                        dp[i][j] -= sum[i - limit - 1][j + cost[i]];
                    }
                }
                sum[i][j] += dp[i][j];
            }
        }
        long numWays = 0;
        for (int i = 0; i <= m; i++) {
            numWays += dp[n][i];
        }
        return numWays;
    }
}
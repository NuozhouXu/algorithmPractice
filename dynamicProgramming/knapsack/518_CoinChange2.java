class Solution {
    // O(mn) time O(mn) space
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j]; // not choose the coin
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]]; // choose the coin
                }
            }
        }
        return dp[coins.length][amount];
    }

    // O(mn) time O(m) space
    public int changeOptimized(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin]; 
            }
        }
        return dp[amount];
    }
}
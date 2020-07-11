class Solution {
    // Top down DP. Time O(S*n). where S is the amount, n is denomination count.
    // Space O(S) dp table
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0) return -1;
        return coinChangeHelper(coins, amount, new int[amount + 1]);        
    }
    
    private int coinChangeHelper(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        
        if (dp[amount] != 0) return dp[amount];
        
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int numCoins = coinChangeHelper(coins, amount - coins[i], dp);
            if (numCoins >= 0 && numCoins < minimum) {
                minimum = numCoins + 1;
            }
        }
        dp[amount] = minimum == Integer.MAX_VALUE ? -1 : minimum;
        return dp[amount];
    }

    // Bottom up DP. Time O(S*n). where S is the amount, n is denomination count.
    // Space O(S) dp table, similar Maximum Ribbon Cut
    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
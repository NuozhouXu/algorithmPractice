class Solution {
    // O(nk) time O(nk) space
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length + 1][2 * k + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= 2 * k; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] - prices[i - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + prices[i - 1]);
                }
            }
        }
        return Math.max(0, dp[prices.length][2 * k]);
    }


    public int maxProfitSaveSpace(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[] prev = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];
        prev[0] = 0;
        for (int i = 1; i <= 2 * k; i++) {
            prev[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) {
                    curr[j] = Math.max(prev[j], curr[j - 1] - prices[i - 1]);
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1] + prices[i - 1]);
                }
            }
            prev = curr;
        }
        return Math.max(0, prev[2 * k]);
    }

    // O(nk) time O(k) space
    public int maxProfitOptimal(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length / 2) {
            return maxProfitUnlimited(prices);
        }
        int[] prev = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];
        prev[0] = 0;
        for (int i = 1; i <= 2 * k; i++) {
            prev[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) {
                    curr[j] = Math.max(prev[j], curr[j - 1] - prices[i - 1]);
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1] + prices[i - 1]);
                }
            }
            prev = curr;
        }
        return Math.max(0, prev[2 * k]);
    }
    
    public int maxProfitUnlimited(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
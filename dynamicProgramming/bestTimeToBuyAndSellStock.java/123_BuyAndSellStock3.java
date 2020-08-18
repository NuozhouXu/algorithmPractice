class Solution {
    // O(n) time O(n) space
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n + 1];
        int leftMin = prices[0];
        int rightMax = prices[n - 1];
        for (int l = 1; l < n; l++) {
            leftProfit[l] = Math.max(leftProfit[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);
            
            int r = n - l - 1;
            rightProfit[r] = Math.max(rightProfit[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            maxAns = Math.max(maxAns, leftProfit[i] + rightProfit[i + 1]);
        }
        return maxAns;
    }

    // O(n) time O(n) space
    public int maxProfitDP(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length + 1][5];
        dp[0][0] = 0;
        for (int i = 1; i < 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] - prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i - 1]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i - 1]);
        }
        return Math.max(0, dp[prices.length][4]);
    }

    // O(n) time O(1) space
    public int maxProfitOptimal(int[] prices) {
        if (prices.length == 0) return 0;
        int s1 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;

        for (int i=0; i < prices.length; i++) {            
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1+prices[i]);
            s3 = Math.max(s3, s2-prices[i]);
            s4 = Math.max(s4, s3+prices[i]);
        }
        return Math.max(0,s4);
    }
}
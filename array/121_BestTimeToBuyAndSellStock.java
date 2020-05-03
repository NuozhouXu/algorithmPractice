class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minimum = Math.min(minimum, prices[i]);
            maximumProfit = Math.max(maximumProfit, prices[i] - minimum);
        }
        return maximumProfit;
    }
}
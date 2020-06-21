class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxDiff = Math.max(maxDiff, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return maxDiff;
    }
}
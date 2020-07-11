class Solution {
    // O(N^2 * M) time O(MN) space
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        if (n == 0 || m == 0) return 0;
        int[] prefixSum = new int[n + 1];
        int[][] dp = new int[n][m + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            dp[i - 1][1] = prefixSum[i];
        }
        for (int i = 2; i <= m; i++) {
            for (int end = i - 1; end < n; end++) {
                int minVal = Integer.MAX_VALUE;
                for (int start = 0; start < end; start++) {
                    minVal = Math.min(minVal, Math.max(dp[start][i - 1], prefixSum[end + 1] - prefixSum[start + 1]));
                }
                dp[end][i] = minVal;
            }
        }
        return dp[n - 1][m];
    }
}
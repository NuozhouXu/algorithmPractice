class Solution {
    // O(n) time O(n) space
    public int maxNonOverlapping(int[] nums, int target) {
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 0);
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum += nums[i - 1];
            dp[i] = dp[i - 1];
            if (prefixSumMap.containsKey(prefixSum - target)) {
                int index = prefixSumMap.get(prefixSum - target);
                if (index < i) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                }
            }
            prefixSumMap.put(prefixSum, i);
        }
        return dp[nums.length];
    }
}
class Solution {
    // DP, dp array records what's the maxSum of the array ending at index i
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, dp[i]);
        }
        return maximum;
    }

    public int maxSubArrayDPConstantSpace(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        
        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
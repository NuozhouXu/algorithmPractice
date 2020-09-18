class Solution {
    // O(n) time
    // O(1) space
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int newMax = Math.max(prevMax + nums[i], currMax);
            prevMax = currMax;
            currMax = newMax;
        }
        return currMax;
    }

    public int robBottomUp(int[] nums) {
        int[] dp = new int[nums.length + 2];

        for (int i = 2; i <= nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] + dp[i - 2]);
        }
        return dp[nums.length + 1];
    }

    public int robTopDown(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robHelper(nums, 0, dp);
    }
    
    private int robHelper(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];
        int max = 0;
        // not rob
        max = Math.max(max, robHelper(nums, index + 1, dp));
        // rob
        max = Math.max(max, nums[index] + robHelper(nums, index + 2, dp));
        dp[index] = max;
        return max;
    }
}
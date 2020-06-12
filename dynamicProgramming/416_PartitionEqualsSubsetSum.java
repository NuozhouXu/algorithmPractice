class Solution {
    // O(NC) time where C is sum / 2
    // O(NC) space
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num: nums) target += num;
        if (target % 2 == 1) return false;
        target /= 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    // O(NC) time where C is sum / 2
    // O(C) space
    public boolean canPartitionOptimal(int[] nums) {
        int target = 0;
        for (int num: nums) target += num;
        if (target % 2 == 1) return false;
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
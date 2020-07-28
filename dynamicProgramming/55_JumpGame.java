class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 1;
        return canJumpFromPosition(0, nums, memo);
    }
    
    private boolean canJumpFromPosition(int position, int[] nums, int[] memo) {
        if (memo[position] != 0) {
            return memo[position] > 0;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums, memo)) {
                memo[position] = 1;
                return true;
            }
        }
        memo[position] = -1;
        return false;
    }

    // O(n^2) time O(n) space
    public boolean canJumpBottomUp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    // O(n) time O(1) space
    public boolean canJumpOptimal(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
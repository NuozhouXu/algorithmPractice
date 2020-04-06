class Solution {
    // Pure recursion O(2^n) time, O(n) space of the recursion tree
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums, S, 0);
    }
    
    private int findTargetSumWaysHelper(int[] nums, int S, int index) {
        if (index == nums.length - 1) {
            int result = 0;
            if (nums[index] == S) result++;
            if (nums[index] == -S) result++;
            return result;
        }
        return findTargetSumWaysHelper(nums, S + nums[index], index + 1) +
            findTargetSumWaysHelper(nums, S - nums[index], index + 1);
    }
}
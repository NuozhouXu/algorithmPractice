class Solution {
    // O(n) time
    // O(1) space
    // 1 2 3 4 5 6 7 8 9
    // ---------------     rob 1 and not rob 9, not rob 1 and not rob 9
    //   ---------------   not rob 1 and rob 9, not rob 1 and not rob 9
    // Above two slice cover all the scenarios
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    public int robHelper(int[] nums, int l, int r) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = l; i <= r; i++) {
            int newMax = Math.max(prevMax + nums[i], currMax);
            prevMax = currMax;
            currMax = newMax;
        }
        return currMax;
    }
}
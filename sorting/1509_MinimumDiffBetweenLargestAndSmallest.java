class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            int j = 3 - i;
            minDiff = Math.min(minDiff, nums[nums.length - j - 1] - nums[i]);
        }
        return minDiff;
    }
}
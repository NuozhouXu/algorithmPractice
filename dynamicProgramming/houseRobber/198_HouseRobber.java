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
}
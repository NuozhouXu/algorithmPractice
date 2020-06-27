class Solution {
    // O(n) time O(1) space
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 1;
        int currLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                 currLength++;
            } else {
                currLength = 1;
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
class Solution {
    // O(n) time
    public int getMaxLen(int[] nums) {
        int[] maxPositiveLen = new int[nums.length + 1];
        int[] maxNegativeLen = new int[nums.length + 1];
        int result = 0;
        
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            if (num > 0) {
                maxPositiveLen[i] = maxPositiveLen[i - 1] + 1;
                maxNegativeLen[i] = maxNegativeLen[i - 1] > 0 ? maxNegativeLen[i - 1] + 1 : 0;
            } else if (num < 0) {
                maxPositiveLen[i] = maxNegativeLen[i - 1] > 0 ? maxNegativeLen[i - 1] + 1 : 0;
                maxNegativeLen[i] = maxPositiveLen[i - 1] + 1;
            }
            result = Math.max(result, maxPositiveLen[i]);
        }
        return result;
    }
}
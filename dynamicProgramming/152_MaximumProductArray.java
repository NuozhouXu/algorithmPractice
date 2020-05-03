class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = minSoFar;
                minSoFar = maxSoFar;
                maxSoFar = temp;
            }
            maxSoFar = Math.max(maxSoFar * nums[i], nums[i]);
            minSoFar = Math.min(minSoFar * nums[i], nums[i]);
            maxResult = Math.max(maxSoFar, maxResult);
        }
        return maxResult;
    }
}
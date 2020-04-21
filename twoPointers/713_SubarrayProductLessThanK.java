class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int windowStart = 0;
        int currentProduct = 1;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentProduct *= nums[windowEnd];
            while (currentProduct >= k && windowStart < windowEnd) {
                currentProduct /= nums[windowStart];
                windowStart++;
            }
            if (currentProduct < k) {
                count += windowEnd - windowStart + 1;
            }
        }
        return count;
    }
}
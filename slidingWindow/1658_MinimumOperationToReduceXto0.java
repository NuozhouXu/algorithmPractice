class Solution {
    // O(n) time O(1) space
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num: nums) total += num;
        int max = -1;
        int windowStart = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while (sum > total - x && windowStart <= windowEnd) {
                sum -= nums[windowStart];
                windowStart++;
            }
            if (sum == total - x) {
                max = Math.max(max, windowEnd - windowStart + 1);
            }
        }
        return max != -1 ? nums.length - max : -1;
    }
}
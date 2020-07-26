class Solution {
    // O(N) time
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
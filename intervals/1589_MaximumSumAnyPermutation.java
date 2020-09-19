class Solution {
    // O(nlogn + m) time
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] count = new int[nums.length];
        for (int[] request: requests) {
            int l = request[0];
            int r = request[1];
            count[l]++;
            if (r + 1 < nums.length) count[r + 1]--;
        }
        for (int i = 1; i < nums.length; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(count);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i] * count[i]) % 1000000007;
        }
        return sum;
    }
}
class Solution {
    // O(nlogn)
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int mod = 1000000007;
        int[] pows = new int[n + 1];
        pows[0] = 1;
        for (int i = 1; i <= n; i++) {
            pows[i] = (pows[i - 1] * 2) % mod;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                count = (count + pows[r - l]) % mod;
                l++;
            }
        }
        return count;
    }
}
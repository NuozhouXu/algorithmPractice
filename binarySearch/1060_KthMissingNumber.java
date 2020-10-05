class Solution {
    // O(logN)
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        
        if (k > missing(n - 1, nums)) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }
        int l = 0, r = n - 1;
        // find the leftest index such that missing(l, nums) >= k
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (missing(mid, nums) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l - 1] + k - missing(l - 1, nums);
    }
    
    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}
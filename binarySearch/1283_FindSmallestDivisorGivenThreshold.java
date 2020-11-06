class Solution {
    // O(Nlog(max(nums)))
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 1000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int sum = 0;
            for (int num: nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
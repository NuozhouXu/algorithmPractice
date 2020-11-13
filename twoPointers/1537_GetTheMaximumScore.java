class Solution {
    // O(m + n)
    public int maxSum(int[] nums1, int[] nums2) {
        long ans = 0;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                ans += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            sum1 += nums1[i++];
        }
        while (j < nums2.length) {
            sum2 += nums2[j++];
        }
        ans += Math.max(sum1, sum2);
        return (int) (ans % 1000000007);
    }
}
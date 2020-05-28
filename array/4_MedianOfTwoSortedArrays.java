class Solution {
    // O(log(min(M, N)))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = nums1.length;
        int count = (nums1.length + nums2.length + 1) / 2;
        while (l <= r) {
            int partition1 = l + (r - l) / 2;
            int partition2 = count - partition1;
            
            int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = partition1 == nums1.length ? Integer.MAX_VALUE: nums1[partition1];
            
            int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];
            
            if (left1 <= right2 && left2 <= right1) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return (double) Math.max(left1, left2);
                } else {
                    return ((double) Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                }
            } else if (left1 > right2) {
                r = partition1 - 1;
            } else {
                l = partition1 + 1;
            }
        }
        return -1.0;
    }
}
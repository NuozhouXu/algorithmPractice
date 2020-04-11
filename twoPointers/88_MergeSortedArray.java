class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int u = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[u--] = nums2[j];
                j--;
            } else {
                nums1[u--] = nums1[i];
                i--;
            }
        }
        while (i >= 0) {
            nums1[u--] = nums1[i];
            i--;
        }
        while (j >= 0) {
            nums1[u--] = nums2[j];
            j--;
        }
    }
}
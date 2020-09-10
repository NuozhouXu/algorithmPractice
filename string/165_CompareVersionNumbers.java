class Solution {
    // O(n + m + max(m, n))
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        for (int i = 0; i < Math.max(n1, n2); i++) {
            int i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            int i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        
        return 0;
    }
}
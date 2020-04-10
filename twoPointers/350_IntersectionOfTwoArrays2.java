class Solution {
    //O(nlogn + mlogm), O(1) space
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                results.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] intersection = new int[results.size()];
        for (int index = 0; index < results.size(); index++) intersection[index] = results.get(index);
        return intersection;
    }
}
class Solution {
    // O(min(k, mn) * logk)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((a, b) -> nums1[a.get(0)] + nums2[a.get(1)] - nums1[b.get(0)] - nums2[b.get(1)]);
        List<List<Integer>> results = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return results;
        for (int i = 0; i < nums2.length && i < k; i++) {
            heap.offer(Arrays.asList(0, i));
        }
        for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
            List<Integer> minPair = heap.poll();
            results.add(Arrays.asList(nums1[minPair.get(0)], nums2[minPair.get(1)]));
            if (minPair.get(0) == nums1.length - 1) continue;
            heap.offer(Arrays.asList(minPair.get(0) + 1, minPair.get(1)));
        }
        return results;
    }
}
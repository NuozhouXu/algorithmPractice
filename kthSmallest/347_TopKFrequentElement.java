class Solution {
    // O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int n: count.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] results = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            results[i++] = heap.poll();
        }
        return results;
    }

    // O(N) time O(N) space
    public int[] topKFrequentBuckets(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int key: count.keySet()) {
            buckets.get(count.get(key) - 1).add(key);
        }
        int[] output = new int[k];
        int index = 0;
        int bucketPtr = nums.length - 1;
        while (bucketPtr >= 0 && index < k) {
            if (buckets.get(bucketPtr).size() > 0) {
                for (int i = 0; i < buckets.get(bucketPtr).size(); i++) {
                    output[index++] = buckets.get(bucketPtr).get(i);
                    if (index == k) break;
                }
            }
            bucketPtr--;
        }
        return output;
    }
}
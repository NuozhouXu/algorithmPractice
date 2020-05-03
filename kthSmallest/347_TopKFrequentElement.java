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

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key: frequency.keySet()) {
            Integer freqNum = frequency.get(key);
            if (buckets[freqNum] == null) {
                buckets[freqNum] = new ArrayList<>();
            }
            buckets[freqNum].add(key);
        }
        
        int count = k;
        List<Integer> results = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (buckets[i] != null) {
                results.addAll(buckets[i]);
                k = k - buckets[i].size();
            }
            if (k <= 0) break;
        }
        return results;
    }
}
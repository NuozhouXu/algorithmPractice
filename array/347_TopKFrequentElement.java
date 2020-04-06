class Solution {
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
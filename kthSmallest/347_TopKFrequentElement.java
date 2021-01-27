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

    // O(n) average case O(n^2) worst case
    public int[] topKFrequentQuickSelect(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int n = count.size();
        int[] unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i++] = num;
        }
        
        quickSelect(unique, count, 0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }
    
    private void quickSelect(int[] nums, Map<Integer, Integer> count, int l, int r, int k) {
        int partitionIndex = randomizedPartition(nums, count, l, r);
        if (partitionIndex == k) {
            return;
        } else if (partitionIndex < k) {
            quickSelect(nums, count, partitionIndex + 1, r, k);
        } else {
            quickSelect(nums, count, l, partitionIndex - 1, k);
        }
    }
    
    private int randomizedPartition(int[] nums, Map<Integer, Integer> count, int l, int r) {
        Random rand = new Random();
        int randPivot = l + rand.nextInt(r - l + 1);
        swap(nums, randPivot, r);
        return partition(nums, count, l, r);
    }
    
    private int partition(int[] nums, Map<Integer, Integer> count, int l, int r) {
        int pivot = nums[r];
        int pivotFreq = count.get(pivot);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (count.get(nums[j]) <= pivotFreq) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
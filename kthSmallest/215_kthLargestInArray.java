class Solution {
    // Time O(nlogk) Space O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (heap.size() == k + 1) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    // Quickselect Time O(n) space O(1)
    public int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivotIndex = randomizedPartition(nums, l, r);
        if (k == pivotIndex) {
            return nums[pivotIndex];
        } else if (k < pivotIndex) {
            return quickSelect(nums, k, l, pivotIndex - 1);
        } else {
            return quickSelect(nums, k, pivotIndex + 1, r);
        }
    }

    private int randomizedPartition(int[] nums, int l, int r) {
        Random rand = new Random();
        int pivotIndex = l + rand.nextInt(r - l + 1);
        swap(nums, pivotIndex, r);
        return partition(nums, l, r);
    }
    
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
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
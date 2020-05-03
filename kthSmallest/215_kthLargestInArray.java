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
    public int findKthLargestOptimal(int[] nums, int k) {
        return findKthHelper(nums, k, 0, nums.length - 1);
    }
    
    private int findKthHelper(int[] nums, int k, int l, int r) {
        if (l == r) return nums[l];
        Random random = new Random();
        int randomIndex = l + random.nextInt(r - l); 
        exchange(nums, randomIndex, r);
        int pivotIndex = partition(nums, l, r);
        if (pivotIndex == nums.length - k) {
            return nums[pivotIndex];
        } else if (pivotIndex < nums.length - k) {
            return findKthHelper(nums, k, pivotIndex + 1, r);
        } else {
            return findKthHelper(nums, k, l, pivotIndex - 1);
        }
    }
    
    private int partition(int[] nums, int l, int r) {
        int pivotVal = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivotVal) {
                i++;
                exchange(nums, i, j);
            }
        }
        exchange(nums, i + 1, r);
        return i + 1;
    }
    
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
class Solution {
    // O(n^2 * logn) time 
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += (nums[j] % 1000000007);
                heap.offer(sum);
            }
        }
        
        int index = 0;
        int sum = 0;
        while (!heap.isEmpty() && index <= right - 1) {
            int num = heap.poll();
            if (index >= left - 1 && index <= right - 1) {
                sum += (num % 1000000007);
            }
            index++;
        }
        return sum;
    }
}
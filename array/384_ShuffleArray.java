class Solution {
    
    private Random rand;
    private int[] original;
    private int[] nums;

    public Solution(int[] nums) {
        this.rand = new Random();
        this.nums = nums;
        this.original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.nums = this.original.clone();
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = this.nums.length - 1; i > 0; i--) {
            int r = this.randRange(0, i);
            this.swap(this.nums, r, i);
        }
        return this.nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    
    private int randRange(int min, int max) {
        return this.rand.nextInt((max - min) + 1) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
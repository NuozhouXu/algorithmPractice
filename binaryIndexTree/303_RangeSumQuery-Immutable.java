class NumArray {
    
    private int[] values;

    public NumArray(int[] nums) {
        this.values = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            values[i] = values[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return values[j + 1] - values[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
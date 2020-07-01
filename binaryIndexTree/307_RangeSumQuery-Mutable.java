class NumArray {
    
    private int[] values;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.values = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
		while (i < values.length) {
			values[i] += diff;
			i += (i & -i);
		}
    }
    
    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += values[i];
            i -= (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
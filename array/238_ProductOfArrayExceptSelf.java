class Solution {
    // O(n) time O(n) space
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] results = new int[nums.length];
        
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            results[i] = L[i] * R[i];
        }
        return results;
    }

    // O(n) time O(1) space
    public int[] productExceptSelfOptimal(int[] nums) {
        if (nums.length == 0) return nums;
        int[] results = new int[nums.length];
        
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] * R;
            R *= nums[i];
        }
        return results;
    }
}
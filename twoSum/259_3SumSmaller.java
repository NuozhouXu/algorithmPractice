class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += twoSum(nums, target - nums[i], i + 1);
        }
        return count;
    }
    
    private int twoSum(int[] nums, int target, int left) {
        int count = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum < target) {
                count += right - left; // important
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
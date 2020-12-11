class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int curr = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[curr++] = nums[i];
            }
        }
        return curr;
    }
}
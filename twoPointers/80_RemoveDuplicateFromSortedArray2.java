class Solution {
    // O(N) time O(1) space
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }
            if (count <= 2) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
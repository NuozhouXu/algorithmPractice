class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int median = (nums.length + 1) / 2;
        int j = 0;
        for (int i = median - 1; i >= 0; i--) {
            nums[j] = copy[i];
            j += 2;
        }
        j = 1;
        for (int i = nums.length - 1; i >= median; i--) {
            nums[j] = copy[i];
            j += 2;
        }
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                output.add(i + 1);
            }
        }
        return output;
    }
}
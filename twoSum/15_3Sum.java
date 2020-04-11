class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            twoSum(nums, -nums[i], i + 1, results);
        }
        return results;
    }
    
    public void twoSum(int[] numbers, int target, int start, List<List<Integer>> results) {
        int i = start, j = numbers.length - 1;
        while (i < j) {
            int currentSum = numbers[i] + numbers[j];
            if (currentSum < target) {
                i++;
            } else if (currentSum > target) {
                j--;
            } else {
                results.add(Arrays.asList(-target, numbers[i], numbers[j]));
                i++;
                j--;
                while (i < j && numbers[i] == numbers[i - 1]) i++;
                while (i < j && numbers[j] == numbers[j + 1]) j--;
            }
        }
    }
}
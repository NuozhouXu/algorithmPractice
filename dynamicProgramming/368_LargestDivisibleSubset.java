class Solution {
    // O(n^2) time O(n^2) space
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for (int num: nums) dp.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && maxSubset.size() < dp.get(j).size()) {
                    maxSubset = dp.get(j);
                }
            }
            dp.get(i).addAll(maxSubset);
            dp.get(i).add(nums[i]);
            if (dp.get(i).size() > result.size()) {
                result = dp.get(i);
            }
        }
        return result;
    }
}
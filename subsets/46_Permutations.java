class Solution {
    // O(n * n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = results.size();
            List<List<Integer>> newResults = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                List<Integer> oldPermutation = results.get(j);
                for (int q = 0; q <= oldPermutation.size(); q++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(q, nums[i]);
                    newResults.add(newPermutation);
                }
            }
            results = newResults;
        }
        return results;
    }

    // O(n * n!)
    public List<List<Integer>> permuteBacktrack(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, results);
        return results;
    }
    
    private void backtrack(int[] nums, int index, List<List<Integer>> results) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num: nums) permutation.add(num);
            results.add(permutation);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                backtrack(nums, index + 1, results);
                swap(nums, index, i);
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
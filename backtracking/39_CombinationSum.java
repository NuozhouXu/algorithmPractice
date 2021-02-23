class Solution {
    // O(2^n * n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combinationSumHelper(candidates, target, new ArrayList<>(), results, 0);
        return results;
    }
    
    private void combinationSumHelper(int[] candidates, int target, List<Integer> tempList, List<List<Integer>> results, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], tempList, results, i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
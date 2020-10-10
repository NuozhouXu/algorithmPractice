class Solution {
    // O(2^n * n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, results, target, 0, new ArrayList<>());
        return results;
    }
    
    private void combinationSum2Helper(int[] candidates, List<List<Integer>> results, int target, int start, List<Integer> tempList) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                combinationSum2Helper(candidates, results, target - candidates[i], i + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
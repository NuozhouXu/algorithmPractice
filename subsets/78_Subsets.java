class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int num: nums) {
            int n = results.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSet = new ArrayList<>(results.get(i));
                newSet.add(num);
                results.add(newSet);
            }
        }
        return results;
    }

    // O(2^n * n)
    public List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
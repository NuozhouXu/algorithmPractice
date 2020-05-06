class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            if (i >= 1 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = results.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> newSet = new ArrayList<>(results.get(j));
                newSet.add(nums[i]);
                results.add(newSet);
            }
        }
        return results;
    }

    public List<List<Integer>> subsetsWithDupBacktrack(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
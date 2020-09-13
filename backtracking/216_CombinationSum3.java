class Solution {
    // O(K * 9!/k!(9 - k)!) time
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        combinationSum3Helper(results, new ArrayList<>(), 1, k, n);
        return results;
    }
    
    private void combinationSum3Helper(List<List<Integer>> results, List<Integer> tempList, int start, int k, int n) {
        if (tempList.size() > k) {
            return;
        } else if (n == 0 && tempList.size() == k) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                combinationSum3Helper(results, tempList, i + 1, k, n - i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

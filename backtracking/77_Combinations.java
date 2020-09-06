class Solution {
    // O(k * C(n, k)) time and space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, 1, new ArrayList<>(), n, k);
        return results;
    }

    private void backtrack(List<List<Integer>> results, int start, List<Integer> tempList, int n, int k) {
        if (tempList.size() == k) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(results, i + 1, tempList, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}
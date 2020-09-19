class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    results.add(num);
                }
            }
        }
        Collections.sort(results);
        return results;
    }
}
class Solution {
    // O(N * 2^N) time O(2^N) space
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(results, i, 1, N, K);
        }
        if (N == 1) results.add(0);
        int[] output = new int[results.size()];
        for (int i = 0; i < results.size(); i++) output[i] = results.get(i);
        return output;
    }
    
    private void dfs(List<Integer> results, int curr, int numDigits, int N, int K) {
        if (numDigits == N) {
            results.add(curr);
            return;
        }
        int lastDigit = curr % 10;
        List<Integer> nextDigits = new ArrayList<>();
        if (K == 0) {
            nextDigits.add(lastDigit);
        } else {
            if (lastDigit + K < 10) {
                nextDigits.add(lastDigit + K);
            }
            if (lastDigit - K >= 0) {
                nextDigits.add(lastDigit - K);
            }
        }
        for (int nextDigit: nextDigits) {
            dfs(results, curr * 10 + nextDigit, numDigits + 1, N, K);
        }
    }
}
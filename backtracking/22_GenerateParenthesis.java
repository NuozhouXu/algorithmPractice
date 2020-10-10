class Solution {
    // O(2^n * n)
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtrack(n, n, "", results);
        return results;
    }
    
    private void backtrack(int numLeftParenthesisNeeded, int numRightParenthesisNeeded, String currStr, List<String> results) {
        if (numLeftParenthesisNeeded == 0 && numRightParenthesisNeeded == 0) {
            results.add(currStr);
            return;
        }
        if (numLeftParenthesisNeeded > 0) {
            backtrack(numLeftParenthesisNeeded - 1, numRightParenthesisNeeded, currStr + "(", results);
        }
        if (numRightParenthesisNeeded > numLeftParenthesisNeeded) {
            backtrack(numLeftParenthesisNeeded, numRightParenthesisNeeded - 1, currStr + ")", results);
        }
    }
}
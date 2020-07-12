class Solution {
    // O(n * sqrt(n)) time O(n) space
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        List<Integer> squares = new ArrayList<>();
        dp[0] = false;
        dp[1] = true;
        for (int i = 1; i <= Math.floor(Math.sqrt(n)); i++) {
            squares.add(i * i);
        }
        for (int i = 2; i <= n; i++) {
            for (int square: squares) {
                if (square <= i) {
                    dp[i] = dp[i] || !dp[i - square];
                    if (dp[i]) break;
                }
            }
        }
        return dp[n];
    }
}
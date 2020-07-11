class Solution {
    // O(n^2) time O(n^2) space
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int range = 0; range < s.length(); range++) {
            for (int start = 0; start < s.length() - range; start++) {
                int end = start + range;
                if (range == 0) {
                    dp[start][end] = 1;
                } else if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // Initialize first row
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        for (int row = 1; row <= s.length(); row++) {
            for (int col = 1; col <= p.length(); col++) {
                if (s.charAt(row - 1) == p.charAt(col - 1) || p.charAt(col - 1) == '?') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (p.charAt(col - 1) == '*') {
                    dp[row][col] = dp[row - 1][col] || dp[row][col - 1];
                } else {
                    dp[row][col] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
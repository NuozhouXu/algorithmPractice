class Solution {
    // O(mn) time O(mn) space
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            dp[i][0] = i + 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i <= S.length(); i++) {
            if (dp[i][T.length()] > 0 && i - dp[i][T.length()] + 1 < minLength) {
                minLength = i - dp[i][T.length()] + 1;
                startIndex = dp[i][T.length()] - 1;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : S.substring(startIndex, startIndex + minLength);
    }
}
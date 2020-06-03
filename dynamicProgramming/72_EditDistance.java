class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        dp[0][0] = 0;
        for (int row = 1; row <= word2.length(); row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col <= word1.length(); col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row <= word2.length(); row++) {
            for (int col = 1; col <= word1.length(); col++) {
                if (word1.charAt(col - 1) == word2.charAt(row - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + Math.min(Math.min(dp[row - 1][col], dp[row - 1][col - 1]), dp[row][col - 1]);
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
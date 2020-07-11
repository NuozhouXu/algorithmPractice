class Solution {
    // O(mn) time O(mn) space
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // print path
        char[] path = new char[dp[text1.length()][text2.length()]];
        int i = text1.length();
        int j = text2.length();
        int k = path.length - 1;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                path[k] = text1.charAt(i - 1);
                i--;
                j--;
                k--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        for (int p = 0; p < path.length; p++) {
            System.out.print(path[p]);
        }
        System.out.println("");
        return dp[text1.length()][text2.length()];
    }
}
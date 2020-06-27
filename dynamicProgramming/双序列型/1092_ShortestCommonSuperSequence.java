class Solution {
    // O(mn) time
    // O(mn) space
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                sb.insert(0, str1.charAt(i - 1));
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                sb.insert(0, str2.charAt(j - 1));
                j--;
            } else {
                sb.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        while(i > 0) {
            sb.insert(0, str1.charAt(i - 1));
            i--;
        }
        while(j > 0) {
            sb.insert(0, str2.charAt(j - 1));
            j--;
        }
        return sb.toString();
    }
}
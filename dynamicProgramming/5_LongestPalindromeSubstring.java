class Solution {
    // DP O(n^2) time and space
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resultStartIndex = 0;
        int maxLength = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
                if (dp[i][j] && j - i + 1 > maxLength) {
                    resultStartIndex = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(resultStartIndex, resultStartIndex + maxLength);
    }

    public String longestPalindromeOptimized(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendFromMiddle(s, i, i);
            int len2 = extendFromMiddle(s, i, i + 1);
            int lenLarge = Math.max(len1, len2);
            if (lenLarge > maxLen) {
                start = i - (lenLarge - 1) / 2;
                maxLen = lenLarge;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    private int extendFromMiddle(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
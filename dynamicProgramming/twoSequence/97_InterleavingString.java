class Solution {
    // O(mn) m is the size of s1, n is size of s2
    // O(mn) space
    // aaa, aaa, aaaaaa
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Boolean> dp = new HashMap<>();
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0, dp);
    }
    
    private boolean isInterleaveHelper(String s1, String s2, String s3, int index1, int index2, int index3, Map<String, Boolean> dp) {
        if (index1 == s1.length()) {
            return s2.substring(index2).equals(s3.substring(index3));
        } else if (index2 == s2.length()) {
            return s1.substring(index1).equals(s3.substring(index3));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(index1).append(" ").append(index2);
            String key = sb.toString();
            if (dp.containsKey(key)) return dp.get(key);
            boolean first = s1.charAt(index1) == s3.charAt(index3) && isInterleaveHelper(s1, s2, s3, index1 + 1, index2, index3 + 1, dp);
            boolean second = s2.charAt(index2) == s3.charAt(index3) && isInterleaveHelper(s1, s2, s3, index1, index2 + 1, index3 + 1, dp);
            boolean result = first | second;
            dp.put(key, result);
            return result;
        }
    }

    // O(mn) time
    // O(mn) space
    public boolean isInterleaveBottomUp(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
class Solution {
    // O(n^2) time O(n^2) space
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        boolean[][] pal = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[s.length()];
    }
}
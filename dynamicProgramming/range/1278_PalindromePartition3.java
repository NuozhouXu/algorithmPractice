class Solution {
    // O(N^2 * K) time O(N^2 + N * K)
    public int palindromePartition(String s, int k) {
        int[][] toPal = new int[s.length()][s.length()];
        int[][] dp = new int[s.length()][k];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                toPal[i][j] = getChanges(s, i, j);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = toPal[0][i];
        }
        for (int i = 1; i < k; i++) {
            for (int end = i; end < s.length(); end++) {
                int minVal = s.length();
                for (int start = 0; start < end; start++) {
                    minVal = Math.min(minVal, dp[start][i - 1] + toPal[start + 1][end]);
                }
                dp[end][i] = minVal;
            }
        }
        return dp[s.length() - 1][k - 1];
    }
    private int getChanges(String s, int start, int end) {
        int changes = 0;
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                changes++;
            }
        }
        return changes;
    }
}
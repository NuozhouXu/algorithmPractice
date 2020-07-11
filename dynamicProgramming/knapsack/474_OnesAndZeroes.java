class Solution {
    // O(mnl) time O(mnl) space
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        
        for (int i = 1; i <= strs.length; i++) {
            int[] count = countZeroesOnes(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= count[0] && k >= count[1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            } 
        }
        return dp[strs.length][m][n];
    }

    // O(mnl) time O(mn) space
    public int findMaxFormSpaceOptimized(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= strs.length; i++) {
            int[] count = countZeroesOnes(strs[i - 1]);
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= count[0] && k >= count[1]) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                    }
                }
            } 
        }
        return dp[m][n];
    }
    
    public int[] countZeroesOnes(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) -'0']++;
        }
        return c;
    }
}
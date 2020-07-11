class Solution {
    
    // O(n^2) time O(n^2) space
    public boolean stoneGameDp(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int size = 2; size <= n; size++) {
            for (int l = 0; l < n - size + 1; l++) {
                int r = l + size - 1;
                dp[l][r] = Math.max(piles[l] - dp[l + 1][r], piles[r] - dp[l][r - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }


    // O(n^2) time O(n) space
    public boolean stoneGameSpaceOptimized(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for (int size = 2; size <= n; size++) {
            for (int l = 0; l < n - size + 1; l++) {
                int r = l + size - 1;
                dp[l] = Math.max(piles[l] - dp[l + 1], piles[r] - dp[l]);
            }
        }
        return dp[0] > 0;
    }

    // O(1)
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
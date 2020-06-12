class Solution {
    // O(N^2) time
    // O(N) space
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        return numTreesHelper(n, dp);
    }
    
    private int numTreesHelper(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += numTreesHelper(i - 1, dp) * numTreesHelper(n - i, dp);
        }
        dp[n] = num;
        return dp[n];
    }

    // O(N^2) time
    // O(N) space
    public int numTreesBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
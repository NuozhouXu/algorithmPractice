class Solution {
    private static int mod = 1000000007;
    // TLE O(n^2 * k)
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return numberOfSetsHelper(n, k, 0, dp) % mod;
    }
    
    private int numberOfSetsHelper(int n, int k, int index, int[][] dp) {
        if (dp[index][k] != -1) return dp[index][k];
        if (index == n - 1 && k > 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int num = 0;
        for (int i = index + 1; i < n; i++) {
            num = (num + numberOfSetsHelper(n, k - 1, i, dp)) % mod;
        }
        num = (num + numberOfSetsHelper(n, k, index + 1, dp)) % mod;
        dp[index][k] = num;
        return num;
    }

    // O(n * k)
    public int numberOfSetsBottomUp(int n, int k) {
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= k; j++) {
            int sum = 0;
            for (int i = n - 2; i >= 0; i--) {
                sum = (sum + dp[i + 1][j - 1]) % mod;
                dp[i][j] = (sum + dp[i + 1][j]) % mod;
            }
        }
        return dp[0][k];
    }
}
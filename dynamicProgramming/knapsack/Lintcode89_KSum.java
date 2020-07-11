public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    // O(mnk) time O(mnk) space
    public int kSum(int[] A, int k, int target) {
        // write your code here
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];

        dp[0][0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m <= target; m++) {
                    dp[i][j][m] = dp[i - 1][j][m];
                    if (j > 0 && m >= A[i - 1]) {
                        dp[i][j][m] += dp[i - 1][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return dp[A.length][k][target];
    }
    
    public int kSumSpaceOptimized(int[] A, int k, int target) {
        // write your code here
        int[][][] dp = new int[2][k + 1][target + 1];
        int prev = 0;
        int curr = 0;

        dp[0][0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            prev = curr;
            curr = 1 - curr;
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m <= target; m++) {
                    dp[curr][j][m] = dp[prev][j][m];
                    if (j > 0 && m >= A[i - 1]) {
                        dp[curr][j][m] += dp[prev][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return dp[curr][k][target];
    }
}
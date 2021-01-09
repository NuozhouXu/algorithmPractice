class Solution {
    public int minDifficultyTopDown(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n][d + 1];
        int maxJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxJob = Math.max(maxJob, jobDifficulty[i]);
            dp[i][1] = maxJob;
            for (int j = 2; j <= d; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return minDifficultyHelper(jobDifficulty, 0, d, dp);
    }
    
    private int minDifficultyHelper(int[] jobDifficulty, int index, int d, int[][] dp) {
        if (dp[index][d] != Integer.MAX_VALUE) {
            return dp[index][d];
        }
        int minDifficulty = Integer.MAX_VALUE;
        int maxJob = 0;
        for (int i = index; i < jobDifficulty.length - d + 1; i++) {
            maxJob = Math.max(maxJob, jobDifficulty[i]);
            minDifficulty = Math.min(minDifficulty, maxJob + minDifficultyHelper(jobDifficulty, i + 1, d - 1, dp));
        }
        dp[index][d] = minDifficulty;
        return minDifficulty;
    }

    // O(n^2 * d) time O(nd) space
    public int minDifficultyBottomUp(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n][d + 1];
        int maxJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxJob = Math.max(maxJob, jobDifficulty[i]);
            dp[i][1] = maxJob;
        }
        for (int j = 2; j <= d; j++) {
            for (int i = 0; i < n - j + 1; i++) {
                int max = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < n - j + 1; k++) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], max + dp[k + 1][j - 1]);
                }
            }
        }
        return dp[0][d];
    }

    // O(n^2 * d) time O(n) space
    public int minDifficultyBottomUpOptimizedSpace(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[] dp = new int[n];
        int maxJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxJob = Math.max(maxJob, jobDifficulty[i]);
            dp[i] = maxJob;
        }
        for (int j = 2; j <= d; j++) {
            for (int i = 0; i < n - j + 1; i++) {
                int max = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int k = i; k < n - j + 1; k++) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i] = Math.min(dp[i], max + dp[k + 1]);
                }
            }
        }
        return dp[0];
    }
}
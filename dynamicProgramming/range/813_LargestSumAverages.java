class Solution {
    // O(N^2 * K) time (NK) space
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        if (N == 0 || K == 0) return 0.0;
        double[] prefixSum = new double[N + 1];
        double[][] dp = new double[N][K + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
            dp[i - 1][1] = prefixSum[i] / i; 
        }
        for (int i = 2; i <= K; i++) {
            for (int end = 0; end < N; end++) {
                double maxVal = Double.MIN_VALUE;
                for (int start = 0; start < end; start++) {
                    maxVal = Math.max(maxVal, dp[start][i - 1] + (prefixSum[end + 1] - prefixSum[start + 1]) / (end - start));
                }
                dp[end][i] = maxVal;
            }
        }
        return dp[N - 1][K];
    }
}
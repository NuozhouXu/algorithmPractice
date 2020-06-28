class Solution {
    // O(n^2) time O(n) space
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int maxAns = 1;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);    
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
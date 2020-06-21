class Solution {
    // O(n) time O(n) space
    // https://leetcode.com/problems/paint-fence/discuss/178010/The-only-solution-you-need-to-read
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n - 1];
    }

    // O(n) time O(1) space 
    public int numWaysOptimal(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int prevLevel = k;
        int currLevel = k * k;
        for (int i = 2; i < n; i++) {
            int temp = (prevLevel + currLevel) * (k - 1);
            prevLevel = currLevel;
            currLevel = temp;
        }
        return currLevel;
    }
}
class Solution {
    // O(n) time O(n) space
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];    
        for (int i = 1; i <= num; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    // O(n) time O(n) space
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
          ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}
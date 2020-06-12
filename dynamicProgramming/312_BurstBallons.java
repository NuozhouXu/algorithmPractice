class Solution {
    // O(n^3) time
    // O(n^2) space
    public int maxCoins(int[] nums) {
        int[] numbers = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) numbers[n++] = x;
        numbers[0] = numbers[n++] = 1;
        
        int[][] dp = new int[n][n];
        return maxCoinsHelper(dp, numbers, 0, n - 1);
    }
    
    private int maxCoinsHelper(int[][] dp, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (dp[left][right] > 0) return dp[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + maxCoinsHelper(dp, nums, left, i) + maxCoinsHelper(dp, nums, i, right));
        }
        dp[left][right] = ans;
        return ans;
    }

    // O(n^3) time
    // O(n^2) space
    public int maxCoinsBottomUp(int[] nums) {
        int[] numbers = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) numbers[n++] = x;
        numbers[0] = numbers[n++] = 1;
        
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) // k is the length of the window we are looking at
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], 
                    numbers[left] * numbers[i] * numbers[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
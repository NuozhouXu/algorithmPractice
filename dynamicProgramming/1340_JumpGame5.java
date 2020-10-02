class Solution {
    // O(nd) time O(n) space where n = arr.length
    public int maxJumps(int[] arr, int d) {
        int res = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(arr, i, d, dp));
        }
        return res;
    }
    
    private int dfs(int[] arr, int i, int d, int[] dp) {
        if (dp[i] != -1) return dp[i];
        int res = 1;
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d) && arr[i] > arr[j]; j++) {
            res = Math.max(res, 1 + dfs(arr, j, d, dp));
        }
        for (int j = i - 1; j >= Math.max(0, i - d) && arr[i] > arr[j]; j--) {
            res = Math.max(res, 1 + dfs(arr, j, d, dp));
        }
        dp[i] = res;
        return res;
    }
}
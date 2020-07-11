class Solution {
    // Pure recursion O(2^n) time, O(n) space of the recursion tree
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums, S, 0);
    }
    
    private int findTargetSumWaysHelper(int[] nums, int S, int index) {
        if (index == nums.length - 1) {
            int result = 0;
            if (nums[index] == S) result++;
            if (nums[index] == -S) result++;
            return result;
        }
        return findTargetSumWaysHelper(nums, S + nums[index], index + 1) +
            findTargetSumWaysHelper(nums, S - nums[index], index + 1);
    }

    public int findTargetSumWaysMemo(int[] nums, int S) {
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
        return findTargetSumWaysMemoHelper(nums, S, 0, dp);
    }
    
    private int findTargetSumWaysMemoHelper(int[] nums, int S, int index, HashMap<Integer, HashMap<Integer, Integer>> dp) {
        if (dp.getOrDefault(index, new HashMap<>()).containsKey(S)) {
            return dp.get(index).get(S);
        }
        if (index == nums.length - 1) {
            int result = 0;
            if (nums[index] == S) result++;
            if (nums[index] == -S) result++;
            return result;
        }
        int result = findTargetSumWaysHelper(nums, S + nums[index], index + 1, dp) +
            findTargetSumWaysHelper(nums, S - nums[index], index + 1, dp);
        HashMap<Integer, Integer> resultMap = dp.getOrDefault(index, new HashMap<>());
        resultMap.put(S, result);
        dp.put(index, resultMap);
        return result;
    }

    public int findTargetSumWaysOptimal(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        return (sum < S || (S + sum) % 2 > 0) ? 0 : subsetSum(nums, (S + sum) / 2); 
    }
    
    public int subsetSum(int[] nums, int s) {
        int[][] dp = new int[nums.length + 1][s + 1];
        dp[0][0] = 1; // Only setting first 0, 0 to 1, since the numbers here can be 0. If nums are all positive, we can set all first column to 1.
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][s];
    }
    
    public int subsetSum2(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++)
            for (int j = s; j >= 0; j--) { // space optimization for 0/1 knapsack, go from the back, because each i, j depends on i - 1, with a smaller j 
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        return dp[s];
    } 
}
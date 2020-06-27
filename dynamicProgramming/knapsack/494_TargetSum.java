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
}
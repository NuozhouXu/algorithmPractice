class Solution {
    public int lengthOfLISTopDown(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int[] l : dp) {
            Arrays.fill(l, -1);
        }
        return lengthOfLISHelper(nums, -1, 0, dp);
    }
    
    private int lengthOfLISHelper(int[] nums, int prevMaxIndex, int currIndex, int[][] dp) {
        if (currIndex == nums.length) return 0;
        if (dp[prevMaxIndex + 1][currIndex] > 0) return dp[prevMaxIndex + 1][currIndex];
        
        int lengthTakenCurrent = 0;
        if (prevMaxIndex < 0 || nums[currIndex] > nums[prevMaxIndex]) {
            lengthTakenCurrent = 1 + lengthOfLISHelper(nums, currIndex, currIndex + 1, dp);
        }
        int lengthNotTakenCurrent = lengthOfLISHelper(nums, prevMaxIndex, currIndex + 1, dp);
        
        int maxLength = Math.max(lengthTakenCurrent, lengthNotTakenCurrent);
        dp[prevMaxIndex + 1][currIndex] = maxLength;
        return maxLength;
    }

    public int lengthOfLISBottomUp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAnswer = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAnswer = Math.max(maxAnswer, dp[i]);
        }
        
        return maxAnswer;
    }

    // O(nlogn)
    public int lengthOfLISOptimal(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
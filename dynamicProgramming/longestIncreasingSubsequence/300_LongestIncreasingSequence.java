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
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAnswer = Math.max(maxAnswer, dp[i]);
        }
        
        return maxAnswer;
    }

    // O(nlogn)
    public int lengthOfLISOptimal(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int mid = l + (r - l) / 2;
                // Find the leftest position, where num can be used
                if (tails[mid] < num) {
                    l = mid + 1; 
                } else {
                    r = mid; 
                }
            }
            tails[l] = num;
            if (l == size) size++;
        }
        return size;
    }
}
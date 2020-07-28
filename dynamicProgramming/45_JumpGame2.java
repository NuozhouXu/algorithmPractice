class Solution {
    // O(n^2) time O(n) space
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int minJump = Integer.MAX_VALUE;
            int furthestJump = Math.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (dp[j] != -1) {
                    minJump = Math.min(minJump, dp[j] + 1);
                }
            }
            dp[i] = minJump == Integer.MAX_VALUE ? -1 : minJump;
        }
        return dp[0];
    }
    // O(n) time O(1) space
    // https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    public int jumpBFS(int[] nums) {
        int numJumps = 0;
        int levelEnd = 0;
        int nextLevelEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextLevelEnd = Math.max(nextLevelEnd, i + nums[i]);
            if (i == levelEnd) {
                numJumps++;
                levelEnd = nextLevelEnd;
            }
        }
        return numJumps;
    }
}
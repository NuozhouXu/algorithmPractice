class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        return largestNumberHelper(cost, target, dp);
    }
    
    private String largestNumberHelper(int[] cost, int target, String[] dp) {
        if (target < 0) return "0";
        if (target == 0) return "";
        if (dp[target] != null) return dp[target];
        String ans = "0";
        for (int i = 9; i >= 1; i--) {
            String curr = largestNumberHelper(cost, target - cost[i - 1], dp);
            if (curr.equals("0")) continue; // skip if can't solve sub-problem
            curr = i + curr;
            if (ans.equals("0") || curr.length() > ans.length()) {
                ans = curr;
            }
        }
        dp[target] = ans;
        return ans;
    }
}
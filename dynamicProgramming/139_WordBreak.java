class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String subStr = s.substring(j, i + 1);
                if (dp[j] && wordSet.contains(subStr)) {
                    dp[i + 1] = dp[j];
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
class Solution {
    // O(N) time O(N) space can be optimized to O(31) space
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day: days) daySet.add(day);
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (daySet.contains(i)) {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
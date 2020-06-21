class Solution {
    // O(n) time O(1) space
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Math.min(costs[i - 1][(j + 1) % 3], costs[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, costs[costs.length - 1][i]);
        }
        return ans;
    }

    // O(n) time O(1) space
    public int minCostNoInputChange(int[][] costs) {
        if (costs.length == 0) return 0;
        int[] prev = new int[3];
        for (int i = 0; i < 3; i++) {
            prev[i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            int[] curr = new int[3];
            for (int j = 0; j < 3; j++) {
                curr[j] = Math.min(prev[(j + 1) % 3], prev[(j + 2) % 3]) + costs[i][j];
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }
}
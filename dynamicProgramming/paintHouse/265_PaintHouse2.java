class Solution {
    // O(mn) time
    // O(1) space
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int numColors = costs[0].length;
        for (int i = 1; i < costs.length; i++) {
            int smallestIndex = -1;
            int secondSmallestIndex = -1;
            for (int j = 0; j < numColors; j++) {
                if (smallestIndex == -1 || costs[i - 1][j] < costs[i - 1][smallestIndex]) {
                    secondSmallestIndex = smallestIndex;
                    smallestIndex = j;
                } else if (secondSmallestIndex == -1 || costs[i - 1][j] < costs[i - 1][secondSmallestIndex]) {
                    secondSmallestIndex = j;
                }
            }
            for (int j = 0; j < numColors; j++) {
                if (secondSmallestIndex == -1) {
                    costs[i][j] = costs[i - 1][j] + costs[i][j];
                } else if (j == smallestIndex) {
                    costs[i][j] = costs[i - 1][secondSmallestIndex] + costs[i][j];
                } else {
                    costs[i][j] = costs[i - 1][smallestIndex] + costs[i][j];
                }
                
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < numColors; i++) {
            ans = Math.min(ans, costs[costs.length - 1][i]);
        }
        return ans;
    }
}
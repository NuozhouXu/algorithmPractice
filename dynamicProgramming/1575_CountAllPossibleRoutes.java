class Solution {
    // O(n^2 * fuel)
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp = new int[locations.length][fuel + 1];
        for (int i = 0; i <= fuel; i++) dp[finish][i] = 1;
        
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < locations.length; i++) {
                for (int k = 0; k < locations.length; k++) {
                    if (k == i) continue;
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % 1000000007; 
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}
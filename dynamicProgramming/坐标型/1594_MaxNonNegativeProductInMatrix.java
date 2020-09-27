class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxSoFar = new long[m][n];
        long[][] minSoFar = new long[m][n];
        maxSoFar[0][0] = (long) grid[0][0];
        minSoFar[0][0] = (long) grid[0][0];
        for (int row = 1; row < m; row++) {
            maxSoFar[row][0] = maxSoFar[row - 1][0] * (long)grid[row][0];
            minSoFar[row][0] = minSoFar[row - 1][0] * (long)grid[row][0];
        }
        for (int col = 1; col < n; col++) {
            maxSoFar[0][col] = maxSoFar[0][col - 1] * (long)grid[0][col];
            minSoFar[0][col] = minSoFar[0][col - 1] * (long)grid[0][col];
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                long val = (long) grid[row][col];
                if (val == 0) {
                    maxSoFar[row][col] = 0;
                    minSoFar[row][col] = 0;
                } else if (val > 0) {
                    maxSoFar[row][col] = Math.max(maxSoFar[row - 1][col] * val, maxSoFar[row][col - 1] * val);
                    minSoFar[row][col] = Math.min(minSoFar[row - 1][col] * val, minSoFar[row][col - 1] * val);
                } else {
                    maxSoFar[row][col] = Math.max(minSoFar[row - 1][col] * val, minSoFar[row][col - 1] * val);
                    minSoFar[row][col] = Math.min(maxSoFar[row - 1][col] * val, maxSoFar[row][col - 1] * val);
                }
            }
        }
        if (maxSoFar[m - 1][n - 1] >= 0L) {
            return (int) (maxSoFar[m - 1][n - 1] % 1000000007);
        } else {
            return -1;
        }
    }
}
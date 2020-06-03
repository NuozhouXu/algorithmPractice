class Solution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    // O(mn) time O(mn) space
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, memo, i, j));
            }
        }
        return ans;    
    }
    
    private int dfs(int[][] matrix, int[][] memo, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];
        for (int[] d: dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col], dfs(matrix, memo, newRow, newCol));
            }
        }
        return ++memo[row][col];
    }
}
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] results = new int[m * n];
        int index = 0, row = 0, col = 0;
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}};
        int currDir = 0;
        while (index <= m * n - 1) {
            results[index++] = matrix[row][col];
            int newRow = row + dirs[currDir][0];
            int newCol = col + dirs[currDir][1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                row = newRow;
                col = newCol;
            } else {
                if (currDir == 0) {
                    if (col == n - 1) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    if (row == m - 1) {
                        col++;
                    } else {
                        row++;
                    }
                }
                currDir = 1- currDir;
            }
        }
        return results;
    }
}
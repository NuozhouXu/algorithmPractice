class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] results = new int[rowSum.length][colSum.length];
        for (int row = 0; row < rowSum.length; row++) {
            for (int col = 0; col < colSum.length; col++) {
                int num = Math.min(rowSum[row], colSum[col]);
                results[row][col] = num;
                rowSum[row] -= num;
                colSum[col] -= num;
            }
        }
        return results;
    }
}
class Solution {
    // O(n^2) time
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        int[][] results = new int[n][n];
        int val = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                results[top][i] = val++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                results[i][right] = val++;
            }
            right--;
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--) {
                results[bottom][i] = val++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                results[i][left] = val++;
            }
            left++;
        }
        return results;
    }
}
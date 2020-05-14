class Solution {
    // O(n^2) time O(1) space
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int level = 0; level < (n + 1) / 2; level++) {
            for (int i = 0; i < n - 2 * level - 1; i++) {
                int temp = matrix[level][level + i]; // top left record
                matrix[level][level + i] = matrix[n - level - 1 - i][level]; // bottom left to top left
                matrix[n - level - 1 - i][level] = matrix[n - level - 1][n - level - 1 - i]; // bottom right to bottom left
                matrix[n - level - 1][n - level - 1 - i] = matrix[level + i][n - level - 1]; // top right to bottom right
                matrix[level + i][n - level - 1] = temp;
            }
        }
    }
}
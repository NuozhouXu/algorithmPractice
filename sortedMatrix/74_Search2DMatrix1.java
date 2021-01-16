class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int l = 0;
        int r = numRows * numCols - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / numCols;
            int col = mid % numCols;
            if (matrix[row][col] < target) {
                l = mid + 1;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
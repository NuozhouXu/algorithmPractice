class Solution {
    // O(MN) time O(1) extra space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return results;
        int rowTop = 0, rowBottom = matrix.length - 1;
        int colLeft = 0, colRight = matrix[0].length - 1;
        while (rowTop <= rowBottom && colLeft <= colRight) {
            for (int col = colLeft; col <= colRight; col++) {
                results.add(matrix[rowTop][col]);
            }
            rowTop++;
            for (int row = rowTop; row <= rowBottom; row++) {
                results.add(matrix[row][colRight]);
            }
            colRight--;
            if (rowTop > rowBottom || colLeft > colRight) break;
            for (int col = colRight; col >= colLeft; col--) {
                results.add(matrix[rowBottom][col]);
            }
            rowBottom--;
            for (int row = rowBottom; row >= rowTop; row--) {
                results.add(matrix[row][colLeft]);
            }
            colLeft++;
        }
        return results;
    }
}
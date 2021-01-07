class Solution {
    // O(mn*log(min(m, n))) time O(min(m, n)) space
    public int[][] diagonalSort(int[][] mat) {
        for (int i = mat.length - 1; i >= 0; i--) {
            sortDiagonal(mat, i, 0);
        }
        
        for (int i = 1; i < mat[0].length; i++) {
            sortDiagonal(mat, 0, i);
        }
        return mat;
    }
    
    private void sortDiagonal(int[][] mat, int startRow, int startCol) {
        int row = startRow;
        int col = startCol;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (row < mat.length && col < mat[0].length) {
            pq.offer(mat[row][col]);
            row++;
            col++;
        }
        row = startRow;
        col = startCol;
        while (row < mat.length && col < mat[0].length) {
            mat[row][col] = pq.poll();
            row++;
            col++;
        }
    }
}
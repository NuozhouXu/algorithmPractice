class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] valueMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueMatrix[i][j] = matrix[i][j];
                if (i > 0 && j > 0) {
                    valueMatrix[i][j] ^= valueMatrix[i - 1][j - 1];
                }
                if (i > 0) {
                    valueMatrix[i][j] ^= valueMatrix[i - 1][j];
                }
                if (j > 0) {
                    valueMatrix[i][j] ^= valueMatrix[i][j - 1];
                }
                pq.offer(valueMatrix[i][j]);
                if (pq.size() == k + 1) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
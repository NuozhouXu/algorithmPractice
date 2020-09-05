class Solution {
    // O(n^2) time
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row: A) {
            for (int i = 0; i * 2 < A[0].length; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[A[0].length - i - 1] ^ 1;
                row[A[0].length - 1 - i] = temp;
            }
        }
        return A;
    }
}
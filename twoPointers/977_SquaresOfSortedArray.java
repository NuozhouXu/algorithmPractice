class Solution {
    public int[] sortedSquares(int[] A) {
        int[] results = new int[A.length];
        int i = 0, j = A.length - 1, r = A.length - 1;
        while (i <= j) {
            int squareLeft = A[i] * A[i];
            int squareRight = A[j] * A[j]; 
            if (squareLeft > squareRight) {
                results[r] = squareLeft;
                i++;
                r--;
            } else {
                results[r] = squareRight;
                j--;
                r--;
            }
        }
        return results;
    }
}
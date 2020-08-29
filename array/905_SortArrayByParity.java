class Solution {
    public int[] sortArrayByParity(int[] A) {
        int evenPtr = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[evenPtr];
                A[evenPtr] = A[i];
                A[i] = temp;
                evenPtr++;
            }
        }
        return A;
    }
}
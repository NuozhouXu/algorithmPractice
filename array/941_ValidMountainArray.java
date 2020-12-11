class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int i = 0;
        while (i < A.length - 1 && A[i + 1] > A[i]) i++;
        if (i == 0 || i == A.length - 1) return false;
        while (i < A.length - 1 && A[i + 1] < A[i]) i++;
        return i == A.length - 1;
    }
}
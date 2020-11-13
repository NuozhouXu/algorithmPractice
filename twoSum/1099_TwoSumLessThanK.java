class Solution {
    // O(nlogn)
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        int ans = -1;
        while (i < j) {
            if (A[i] + A[j] < K) {
                ans = Math.max(ans, A[i] + A[j]);
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }
}
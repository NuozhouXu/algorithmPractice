class Solution {
    // O(N) time O(1) space
    public int longestMountain(int[] A) {
        int ans = 0;
        int i = 1;
        while (i < A.length) {
            while (i < A.length && A[i - 1] == A[i]) i++;
            int up = 0;
            while (i < A.length && A[i - 1] < A[i]) {
                i++;
                up++;
            }
            int down = 0;
            while (i < A.length && A[i - 1] > A[i]) {
                i++;
                down++;
            }
            if (up > 0 && down > 0) {
                ans = Math.max(ans, up + down + 1);
            }
        }
        return ans;
    }
}
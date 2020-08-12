class Solution {
    // O(logM) where M = 2^n - 1 or O(n) time O(1) space
    public char findKthBit(int n, int k) {
        int len = (int) Math.pow(2, n) - 1;
        int sign = 1;
        k--;
        while (len > 1) {
            int mid = len / 2;
            if (k == mid) {
                return sign > 0 ? '1' : '0';
            } else if (k < mid) {
                len /= 2;
            } else {
                sign = -sign;
                k = len - k - 1;
                len /= 2;
            }
        }
        return sign > 0 ? '0' : '1';
    }
}
class Solution {
    public int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return m & n;
    }
}
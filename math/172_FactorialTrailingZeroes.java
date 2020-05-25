class Solution {
    public int trailingZeroes(int n) {
        int numZeroes = 0;
        while (n > 1) {
            n = n / 5;
            numZeroes += n;
        }
        return numZeroes;
    }
}
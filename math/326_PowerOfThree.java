class Solution {
    // O(log_3(n)) time O(1) space
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeLog(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThreeOptimized(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
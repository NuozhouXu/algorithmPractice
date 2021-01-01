class Solution {
    // O(logn) time O(1) space
    public int arrangeCoins(int n) {
        long l = 1;
        long r = n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long val = mid * (mid + 1) / 2;
            
            if (val == n) return (int) mid;
            else if (val > n) r = mid - 1;
            else l = mid + 1;
        }
        return (int) r;
    }
}
class Solution {
    // O(nlog(n))
    public int concatenatedBinary(int n) {
        long curr = 0;
        for (int i = 1; i <= n; i++) {
            int numShift = getBinaryLen(i);
            curr = ((curr << numShift) + i) % 1000000007;
        }
        return (int) curr;
    }

    // log(n)
    private int getBinaryLen(int n) {
        int count = 0;
        while (n != 0) {
            n >>= 1;
            count++;
        }
        return count;
    }

    // O(n)
    public int concatenatedBinaryOptimal(int n) {
        long curr = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) len++;
            curr = ((curr << len) + i) % 1000000007;
        }
        return (int) curr;
    }
}
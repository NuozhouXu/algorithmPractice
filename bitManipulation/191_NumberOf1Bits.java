public class Solution {
    // you need to treat n as an unsigned value
    //doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
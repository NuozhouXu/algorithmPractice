class Solution {
    // O(N) time
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int numSatisfied = 0;
        int max = 0;
        int curr = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
            if (grumpy[windowEnd] == 1) {
                curr += customers[windowEnd];
            } else {
                numSatisfied += customers[windowEnd];
            }
            if (windowEnd - windowStart >= X) {
                if (grumpy[windowStart] == 1) {
                    curr -= customers[windowStart];
                }
                windowStart++;
            }
            max = Math.max(max, curr);
        }
        return max + numSatisfied; 
    }
}
class Solution {
    // O(n) time O(1) space
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int windowStart = 0;
        int numZeroes = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                numZeroes++;
            }
            while (numZeroes > 1) {
                if (nums[windowStart] == 0) {
                    numZeroes--;
                }
                windowStart++;
            }
            maxNum = Math.max(maxNum, windowEnd - windowStart + 1);
        }
        return maxNum;
    }

    // What if the input numbers come in one by one as an infinite stream? 
    // In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
}
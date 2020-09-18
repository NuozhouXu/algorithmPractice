class Solution {
    // O(n) time O(1) space
    public int longestOnes(int[] A, int K) {
        int maxLen = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            if (A[windowEnd] == 0) K--;
            while (K < 0) {
                if (A[windowStart] == 0) K++;
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    // What if the input numbers come in one by one as an infinite stream? 
    // In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?

    public int longestOnesStream(int[] A, int K) {
        int maxLen = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            if (A[windowEnd] == 0) queue.offer(windowEnd);
            if (queue.size() > K) {
                windowStart = queue.poll() + 1;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}
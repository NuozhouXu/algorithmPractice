class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlicesSpace(int[] A) {
        int curr = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr++;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlicesSlidingWindow(int[] A) {
        if (A.length <= 2) return 0;
        int n = A.length;
        int ans = 0;
        int windowStart = 0;
        int currDiff = 0;
        for (int windowEnd = 1; windowEnd < n; windowEnd++) {
            if (A[windowEnd] - A[windowEnd - 1] != currDiff) {
                currDiff = A[windowEnd] - A[windowEnd - 1];
                windowStart = windowEnd - 1;
            }
            if (windowEnd - windowStart + 1 >= 3) {
                ans += (windowEnd - windowStart - 1);
            }
        }
        return ans;
    }
}
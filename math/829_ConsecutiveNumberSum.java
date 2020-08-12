class Solution {
    // https://leetcode.com/problems/consecutive-numbers-sum/discuss/128959/JavaPython-3-5-liners-O(N-0.5)-Math-method-w-explanation-and-analysis.
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int i = 1; i * (i - 1) / 2 < N; ++i)
            if ((N - i * (i - 1) / 2) % i == 0)
                ++ans;
        return ans;
    }
}
class Solution {
    // O(N^2)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int ans = 0;
        int[] maxLens = new int[n];
        int[] counts = new int[n];
        for (int i = 0; i < nums.length; i++) {
            maxLens[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (maxLens[i] == maxLens[j] + 1) {
                        counts[i] += counts[j];
                    } else if (maxLens[i] < maxLens[j] + 1) {
                        maxLens[i] = maxLens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
            if (maxLen == maxLens[i]) {
                ans += counts[i];
            } else if (maxLen < maxLens[i]) {
                ans = counts[i];
                maxLen = maxLens[i];
            }
        }
        return ans;
    }
}
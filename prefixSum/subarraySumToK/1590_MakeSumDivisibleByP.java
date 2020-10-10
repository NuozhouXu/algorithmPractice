class Solution {
    public int minSubarray(int[] nums, int p) {
        int remainder = 0, prefixSum = 0;
        int n = nums.length, minLen = n;
        for (int num: nums) {
            remainder = (remainder + num) % p; 
        }
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            prefixSumToIndex.put(prefixSum, i);
            int key = (prefixSum - remainder + p) % p;
            if (prefixSumToIndex.containsKey(key)) {
                minLen = Math.min(minLen, i - prefixSumToIndex.get(key));
            }
        }
        return minLen == n ? -1 : minLen;
    }
}
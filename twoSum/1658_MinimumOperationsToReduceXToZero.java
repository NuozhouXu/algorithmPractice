class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] prefixSumFront = new int[n + 1];
        int[] prefixSumBack = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            prefixSumFront[i] = prefixSumFront[i - 1] + nums[i - 1];
            prefixSumBack[i] = prefixSumBack[i - 1] + nums[n - i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(prefixSumBack[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int sumFront = prefixSumFront[i];
            int complement = x - sumFront;
            if (map.containsKey(complement)) {
                if (i + map.get(complement) <= n) {
                    ans = Math.min(ans, i + map.get(complement));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
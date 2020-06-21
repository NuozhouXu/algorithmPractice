class Solution {
    // O(N) time
    // O(N) space
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        int[] minimumEndingAt = new int[arr.length];
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int k = sum - target;
            minimumEndingAt[i] = i > 0 ? minimumEndingAt[i - 1] : Integer.MAX_VALUE;
            if (prefixSumMap.containsKey(k)) {
                int prevIndex = prefixSumMap.get(k);
                if (prevIndex > -1 && minimumEndingAt[prevIndex] != Integer.MAX_VALUE)
                    ans = Math.min(ans, i - prevIndex + minimumEndingAt[prevIndex]);
                minimumEndingAt[i] = Math.min(minimumEndingAt[i], i - prevIndex);
            }
            prefixSumMap.put(sum, i);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
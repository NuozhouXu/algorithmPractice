class Solution {
    // exactly K distinct
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }
    
    private int subarraysWithAtMostKDistinct(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        int numSubarrays = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            int numEnd = A[windowEnd];
            count.put(numEnd, count.getOrDefault(numEnd, 0) + 1);
            while (count.size() > K) {
                int numStart = A[windowStart];
                count.put(numStart, count.get(numStart) - 1);
                if (count.get(numStart) == 0) count.remove(numStart);
                windowStart++;
            }
            numSubarrays += windowEnd - windowStart + 1;
        }
        return numSubarrays;
    }
}
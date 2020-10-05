class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        int numPairs = 0;
        for (int num: count.keySet()) {
            if (k == 0) {
                if (count.get(num) >= 2) {
                    numPairs++;
                }
            } else {
                if (count.containsKey(num + k)) {
                    numPairs++;
                }
            }
        }
        return numPairs;
    }
}
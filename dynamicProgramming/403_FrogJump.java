class Solution {
    // O(n ^ 2) time
    // O(n ^ 2) space
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            dp.put(stones[i], new HashSet<>());
        }
        dp.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k: dp.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && dp.containsKey(stones[i] + step)) {
                        dp.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return dp.get(stones[stones.length - 1]).size() > 0;
    }
}
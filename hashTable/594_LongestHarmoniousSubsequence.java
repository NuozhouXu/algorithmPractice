class Solution {
    // O(n) time O(n) space
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num: nums) {
            if (count.containsKey(num + 1)) {
                ans = Math.max(ans, count.get(num) + count.get(num + 1));
            }
        }
        return ans;
    }

    public int findLHSOnePass(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.containsKey(num + 1)) {
                ans = Math.max(ans, count.get(num) + count.get(num + 1));
            }
            if (count.containsKey(num - 1)) {
                ans = Math.max(ans, count.get(num) + count.get(num - 1));
            }
        }
        return ans;
    }
}
class Solution {
    // O(N) time O(N) space
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] output = new int[2];
        int index = 0;
        for (int key: map.keySet()) {
            if (map.get(key) == 1) {
                output[index++] = key;
            }
        }
        return output;
    }
}
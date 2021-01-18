class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - current;
            if (map.getOrDefault(complement, 0) > 0) {
                // remove complement from the map
                map.put(complement, map.get(complement) - 1);
                count++;
            } else {
                 // add current element in the map
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }
        return count;
    }
}
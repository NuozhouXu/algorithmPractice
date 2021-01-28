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

    // O(N) time O(1) space
    public int[] singleNumberBit(int[] nums) {
        // get x^y
        int bitmask = 0;
        for (int num: nums) {
            bitmask ^= num;
        }

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num: nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }

        return new int[]{x, bitmask^x};
    }
}
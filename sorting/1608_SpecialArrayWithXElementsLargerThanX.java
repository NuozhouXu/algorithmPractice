class Solution {
    // Brute force O(n^2)
    public int specialArray(int[] nums) {
        for (int x = 0; x <= nums.length; x++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= x) count++;
            }
            if (count == x) return x;
        }
        return -1;
    }

    // O(nlogn) time
    public int specialArraySort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int x = nums.length - i;
            boolean cond1 = x <= nums[i];
            boolean cond2 = (i == 0) || (x > nums[i - 1]);
            if (cond1 && cond2) return x;
        }
        return -1;
    }
}
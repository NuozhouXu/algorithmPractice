class Solution {
    // O(n) time O(1) space
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if (nums.length == 0) return results;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        for (int num: nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num: nums) {
            if (candidate1 == num) count1++;
            else if (candidate2 == num) count2++;
        }
        if (count1 > nums.length / 3) results.add(candidate1);
        if (count2 > nums.length / 3) results.add(candidate2);
        return results;
    }
}
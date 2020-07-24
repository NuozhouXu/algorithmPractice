class Solution {
    // O(nlogn) time 
    // https://leetcode.com/problems/array-partition-i/discuss/102170/Java-Solution-Sorting.-And-rough-proof-of-algorithm.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
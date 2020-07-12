class Solution {
    // O(N) time O(N) space
    public int numIdenticalPairs(int[] nums) {
        int res = 0, count[] = new int[101];
        for (int num: nums) {
            res += count[num]++;
        }
        return res;
    }
}
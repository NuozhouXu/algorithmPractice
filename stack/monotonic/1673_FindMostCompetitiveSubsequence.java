class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k)
                stack.push(nums[i]);
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
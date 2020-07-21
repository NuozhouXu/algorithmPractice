class Solution {
    // O(N) time O(N) space
    public int[] nextGreaterElements(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                output[stack.pop()] = num;
            }
            if (i < nums.length) stack.push(i);
        }
        return output;
    }
}
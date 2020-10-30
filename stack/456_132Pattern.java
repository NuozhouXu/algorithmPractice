class Solution {
    // 3 1 4 2
    // 3 1 1 1
    // stack 2 4 1
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] > min[k]) {
                // The stack maintains a monotonous decreasing j elements from the right larger than i value
                while (!stack.isEmpty() && stack.peek() <= min[k])
                    stack.pop();
                // If elements larger than i is not empty, and 
                if (!stack.isEmpty() && stack.peek() < nums[k])
                    return true;
                stack.push(nums[k]);
            }
        }
        return false;
    }
}
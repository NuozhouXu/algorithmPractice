class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int newStone = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && newStone < 0 && Math.abs(stack.peek()) < Math.abs(newStone)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(newStone);
            } else {
                if (stack.peek() > 0 && newStone < 0) {
                    if (Math.abs(stack.peek()) == Math.abs(newStone)) {
                        stack.pop();
                    }
                } else {
                    stack.push(newStone);
                }
            }
        }
        int[] output = new int[stack.size()];
        int index = output.length - 1;
        while (!stack.isEmpty()) {
            output[index--] = stack.pop();
        }
        return output;
    }
}
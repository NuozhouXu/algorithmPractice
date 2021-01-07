class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (String op: ops) {
            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                int newNum = first + second;
                stack.push(second);
                stack.push(first);
                stack.push(newNum);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
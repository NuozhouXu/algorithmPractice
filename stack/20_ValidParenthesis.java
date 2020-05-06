class Solution {
    public boolean isValid(String s) {
        // O(n) space
        Deque<Character> stack = new ArrayDeque<>();
        // O(n) time
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                Character stackTop = stack.peek();
                if (stackTop == null) return false;
                if ((stackTop == '(' && c == ')') ||
                    (stackTop == '{' && c == '}') ||
                    (stackTop == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
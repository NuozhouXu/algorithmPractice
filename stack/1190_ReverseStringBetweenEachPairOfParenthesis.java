class Solution {
    // O(n^2)
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                List<Character> temp = new ArrayList<>();
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop();
                for (char ch: temp) {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
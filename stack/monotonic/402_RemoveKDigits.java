class Solution {
    // O(N) time
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
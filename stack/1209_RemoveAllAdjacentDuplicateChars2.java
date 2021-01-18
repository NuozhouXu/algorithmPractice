class Pair {
    public char letter;
    public int count;
    
    public Pair(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek().letter) {
                stack.push(new Pair(c, 1));
            } else {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.letter);
            }
        }
        return sb.reverse().toString();
    }
}
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        Set<String> results = new HashSet<>();
        backtrack(s, 0, 0, 0, left, right, new StringBuilder(), results);
        return new ArrayList<>(results);
    }
    
    private void backtrack(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder sb, Set<String> results) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                results.add(sb.toString());
            }
        } else {
            char c = s.charAt(index);
            if ((c == '(' && leftRem > 0) || (c == ')' && rightRem > 0)) {
                backtrack(s, index + 1, leftCount, rightCount, leftRem - (c == '(' ? 1 : 0), rightRem - (c == ')' ? 1 : 0), sb, results);
            }
            sb.append(c);
            if (c != '(' && c != ')') {
                backtrack(s, index + 1, leftCount, rightCount, leftRem, rightRem, sb, results);
            } else if (c == '(') {
                backtrack(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, sb, results);
            } else if (c == ')') {
                if (rightCount < leftCount) {
                    backtrack(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, sb, results);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
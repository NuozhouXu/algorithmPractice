class Solution {
    public List<String> letterCasePermutation(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> results = new ArrayList<>();
        helper(S, 0, results, sb);
        return results;
    }
    
    private void helper(String S, int index, List<String> results, StringBuilder sb) {
        if (index == S.length()) {
            results.add(sb.toString());
            return;
        }
        char c = S.charAt(index);
        if (Character.isDigit(c)) {
            sb.append(c);
            helper(S, index + 1, results, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toUpperCase(c));
            helper(S, index + 1, results, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toLowerCase(c));
            helper(S, index + 1, results, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
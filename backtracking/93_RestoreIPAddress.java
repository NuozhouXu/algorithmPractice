class Solution {
    // O(1) time O(1) space
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if(s.length() > 12) return results;
        backtrack(results, "", s, 0, 0);
        return results;
    }

    private void backtrack(List<String> results, String temp, String s, int index, int count) {
        if (count < 4 && index >= s.length()) return;
        if (count == 4 && index == s.length()) {
            results.add(temp);
            return;
        }
        for (int i = index; i < Math.min(s.length(), index + 3); i++) {
            String segment = s.substring(index, i + 1);
            if (Integer.valueOf(segment) > 255) break;
            String newStr = i == s.length() - 1 ? temp + segment : temp + segment + ".";
            backtrack(results, newStr, s, i + 1, count + 1);
            if (s.charAt(index) == '0') break;
        }
    }
}
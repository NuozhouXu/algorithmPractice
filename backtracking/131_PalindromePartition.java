class Solution {
    // O(n * 2^n) time, O(n) space
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(s, new ArrayList<>(), results, 0);
        return results;
    }
    
    private void backtrack(String s, List<String> curr, List<List<String>> results, int index) {
        if (index == s.length()) {
            results.add(new ArrayList<>(curr));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    curr.add(s.substring(index, i + 1));
                    backtrack(s, curr, results, i + 1);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // O(2^n) DP optimization https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
}
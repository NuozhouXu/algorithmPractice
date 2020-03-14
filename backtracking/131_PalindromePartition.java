class Solution {
    // O(n * 2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), 0, s);
        return results;
    }
    
    private void backtrack(List<List<String>> results, List<String> currentPartition, int startIndex, String s) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(currentPartition));
            return;
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(startIndex, i, s)) {
                    currentPartition.add(s.substring(startIndex, i + 1));
                    backtrack(results, currentPartition, i + 1, s);
                    currentPartition.remove(currentPartition.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
        }

        return true;
    }

    // O(2^n) DP optimization https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
}
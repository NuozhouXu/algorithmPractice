class Solution {

    // O(N) time O(N) space
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int len = 0;
        boolean foundOdd = false;
        for (Character key: count.keySet()) {
            len += count.get(key) / 2 * 2;
            if (!foundOdd && count.get(key) % 2 == 1) {
                len++;
                foundOdd = true;
            }
        }
        return len;
    }
}
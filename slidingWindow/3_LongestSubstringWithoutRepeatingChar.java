class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int windowStart = 0;
        int longestLength = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (window.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, window.get(rightChar) + 1);
            }
            window.put(rightChar, windowEnd);
            longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
        }
        return longestLength;
    }
}
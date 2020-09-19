class Solution {
    // at most K distinct
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> window = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            while (window.size() > k) {
                char leftChar = s.charAt(windowStart);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) window.remove(leftChar);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
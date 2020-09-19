class Solution {
    // at most 2 distinct
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            count.put(endChar, count.getOrDefault(endChar, 0) + 1);
            while (count.size() > 2) {
                char startChar = s.charAt(windowStart);
                count.put(startChar, count.get(startChar) - 1);
                if (count.get(startChar) == 0) count.remove(startChar);
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}
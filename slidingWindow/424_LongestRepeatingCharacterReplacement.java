class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxLetterCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxLetterCount = Math.max(maxLetterCount, map.get(rightChar));
            if (windowEnd - windowStart + 1 - maxLetterCount > k) {
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
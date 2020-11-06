class Solution {
    public int maxPower(String s) {
        int maxLen = 0;
        Map<Character, Integer> count = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.size() > 1) {
                char cStart = s.charAt(windowStart);
                count.put(cStart, count.get(cStart) - 1);
                windowStart++;
                if (count.get(cStart) == 0) {
                    count.remove(cStart);
                }
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}
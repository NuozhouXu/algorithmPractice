class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int windowStart = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int minStartIndex = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) matched++;
            }
            while (matched == t.length()) {
                if (windowEnd - windowStart + 1 < minLength) {
                    minLength = windowEnd - windowStart + 1;
                    minStartIndex = windowStart;
                }
                
                char leftChar = s.charAt(windowStart);
                windowStart++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minStartIndex + minLength);
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int windowStart = 0, matched = 0;
        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
            char rightChar = s2.charAt(windowEnd);
            if (s1Map.containsKey(rightChar)) {
                s1Map.put(rightChar, s1Map.get(rightChar) - 1);
                if (s1Map.get(rightChar) == 0) matched++;
            }
            
            if (matched == s1Map.size()) return true;
            
            if (windowEnd >= s1.length() - 1) {
                char leftChar = s2.charAt(windowStart);
                windowStart++;
                if (s1Map.containsKey(leftChar)) {
                    if (s1Map.get(leftChar) == 0) matched--;
                    s1Map.put(leftChar, s1Map.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}
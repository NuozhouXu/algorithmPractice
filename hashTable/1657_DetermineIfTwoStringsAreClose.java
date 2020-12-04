class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> count1 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            count2.put(c, count2.getOrDefault(c, 0) + 1);
        }
        
        if (!count1.keySet().equals(count2.keySet())) {
            return false;   
        }
        
        List<Integer> sortedCount1 = new ArrayList<>(count1.values());
        Collections.sort(sortedCount1);
        List<Integer> sortedCount2 = new ArrayList<>(count2.values());
        Collections.sort(sortedCount2);
        
        return sortedCount1.equals(sortedCount2);
    }
}
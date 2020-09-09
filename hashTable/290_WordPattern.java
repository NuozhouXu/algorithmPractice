class Solution {
    // O(N) where N is the length of pattern
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<String, Character> wordToChar = new HashMap();
        Map<Character, String> charToWord = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            if (wordToChar.containsKey(words[i]) && wordToChar.get(words[i]) != pattern.charAt(i) ||
                    charToWord.containsKey(pattern.charAt(i)) && !charToWord.get(pattern.charAt(i)).equals(words[i])) return false;
            wordToChar.put(words[i], pattern.charAt(i));
            charToWord.put(pattern.charAt(i), words[i]);
        }
        return true;
    }
}
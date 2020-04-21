class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) return new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordsCount = words.length, wordLength = words[0].length();
        List<Integer> results = new ArrayList<>();
        if (s.length() < wordsCount * wordLength) return results;
        for (int windowStart = 0; windowStart <= s.length() - wordsCount * wordLength; windowStart++) {
            HashMap<String, Integer> seen = new HashMap<>();
            for (int i = 0; i < wordsCount; i++) {
                int nextWordIndex = windowStart + i * wordLength;
                String nextWord = s.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!map.containsKey(nextWord)) break;
                seen.put(nextWord, seen.getOrDefault(nextWord, 0) + 1);
                if (seen.get(nextWord) > map.get(nextWord)) break;
                if (i + 1 == wordsCount) results.add(windowStart);
            }
        }
        return results;
    }
}
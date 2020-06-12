class Solution {
    // O(N * L^2) where N is the length of words, and L is the average length of word in words
    // O(N) space
    public int longestStrChain(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();
        int ans = 0;
        for (String word: words) wordSet.add(word);
        for (String word: words) {
            ans = Math.max(ans, longestStrChainHelper(wordSet, memo, word));
        }
        return ans;
    }
    
    private int longestStrChainHelper(Set<String> wordSet, Map<String, Integer> memo, String currWord) {
        if (memo.containsKey(currWord)) return memo.get(currWord);
        int length = 0;
        for (int i = 0; i < currWord.length(); i++) {
            String newWord = currWord.substring(0, i) + currWord.substring(i + 1);
            if (wordSet.contains(newWord)) {
                length = Math.max(length, longestStrChainHelper(wordSet, memo, newWord));
            }
        }
        memo.put(currWord, length + 1);
        return length + 1;
    }
}
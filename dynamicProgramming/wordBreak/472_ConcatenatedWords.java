class Solution {
    // O(N * L^2) N is length of words, L is the average length of the word in words
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return result;
    }
    
    public boolean wordBreak(String s, Set<String> wordSet) {
        if (wordSet.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String subStr = s.substring(j, i + 1);
                if (dp[j] && wordSet.contains(subStr)) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
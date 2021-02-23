class TrieNode {
    
    private TrieNode[] children;
    private List<Integer> indexes;
    private int wordEnding;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.indexes = new ArrayList<>();
        this.wordEnding = -1;
    }
    
    public boolean containsKey(char c) {
        return this.children[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return this.children[c - 'a'];
    }
    
    public void put(char c, TrieNode node) {
        this.children[c - 'a'] = node;
    }
    
    public List<Integer> getIndexes() {
        return this.indexes;
    }
    
    public void addIndex(int index) {
        this.indexes.add(index);
    }
    
    public void setWordEnding(int index) {
        this.wordEnding = index;
    }
    
    public int getWordEnding() {
        return this.wordEnding;
    }
}

class Solution {
    
    private boolean isPalindrome(String s, int i) {
        int l = i;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    
    // O(k^2 * n) where k is the length of longest word, n is the number of words
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = new StringBuilder(word).reverse().toString();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                if (isPalindrome(reversedWord, j)) {
                    curr.addIndex(i);
                }
                char c = reversedWord.charAt(j);
                if (!curr.containsKey(c)) {
                    curr.put(c, new TrieNode());
                }
                curr = curr.get(c);
            }
            curr.setWordEnding(i);
        }
        
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                // case 3
                if (curr.getWordEnding() != -1 && isPalindrome(word, j)) {
                    results.add(Arrays.asList(i, curr.getWordEnding()));
                }
                char c = word.charAt(j);
                curr = curr.get(c);
                if (curr == null) break;
            }
            if (curr == null) continue;
            // case 1
            if (curr.getWordEnding() != -1 && curr.getWordEnding() != i) {
                results.add(Arrays.asList(i, curr.getWordEnding()));
            }
            for (int other: curr.getIndexes()) {
                results.add(Arrays.asList(i, other));
            }
        }
        return results;
    }
}
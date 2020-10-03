class TrieNode {
    public TrieNode[] nodes;
    public boolean isEnd;
    public TrieNode() {
        nodes = new TrieNode[26];
        isEnd = false;
    }
    
    public boolean containsKey(char c) {
        return nodes[c - 'a'] != null;
    }
    
    public void put(char c, TrieNode node) {
        nodes[c - 'a'] = node;
    }
    
    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }
}

class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.isEnd = true;
    }
    
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (char nextC = 'a'; nextC <= 'z'; nextC++) {
                    if (node.containsKey(nextC) && searchInNode(word.substring(i + 1), node.get(nextC))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.containsKey(c)) return false;
                else node = node.get(c);
            }
        }
        return node.isEnd;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
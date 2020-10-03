class TrieNode {
    TrieNode[] children;
    List<Integer> wordIndexes;
        
    public TrieNode() {
        this.children = new TrieNode[26];
        this.wordIndexes = new ArrayList<>();
    }
    
    public boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return children[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        children[c - 'a'] = node;
    }
}


class Solution {
    
    // O(N * 26^L * L) where N is number of words and L is the length of words
    public List<List<String>> wordSquares(String[] words) {
        TrieNode root = buildTrie(words);
        int n = words[0].length();
        List<List<String>> results = new ArrayList<>();
        for (String word: words) {
            List<String> tempList = new ArrayList<>();
            tempList.add(word);
            backtrack(words, results, tempList, 1, n, root);
        }
        return results;
    }
    
    private void backtrack(String[] words, List<List<String>> results, List<String> tempList, int step, int n, TrieNode root) {
        if (step == n) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String word: tempList) {
            sb.append(word.charAt(step));
        }
        for (int index: getWordsWithPrefix(root, sb.toString())) {
            tempList.add(words[index]);
            backtrack(words, results, tempList, step + 1, n, root);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.put(c, newNode);
                    node = node.get(c);
                }
                node.wordIndexes.add(i);
            }
        }
        return root;
    }
    
    private List<Integer> getWordsWithPrefix(TrieNode root, String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return new ArrayList<>();
            }
        }
        return node.wordIndexes;
    }
}
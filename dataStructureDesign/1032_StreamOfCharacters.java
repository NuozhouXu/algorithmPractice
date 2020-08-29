class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd = false;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class StreamChecker {
    
    TrieNode root;
    List<Character> lst;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        lst = new ArrayList<>();
        for (String word: words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) node.put(c, new TrieNode());
                node = node.get(c);
            }
            node.setEnd();
        }
    }
    
    public boolean query(char letter) {
        lst.add(letter);
        TrieNode node = root;
        for (int i = lst.size() - 1; i >= 0; i--) {
            char c = lst.get(i);
            if (node.isEnd()) return true;
            if (!node.containsKey(c)) return false;
            node = node.get(c);
        }
        return node.isEnd();
    }
}

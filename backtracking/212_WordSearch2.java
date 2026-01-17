class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, root, results, i, j);
            }
        }
        return results;
    }
    
    private void backtrack(char[][] board, TrieNode node, List<String> results, int row, int col) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] == '0' || node.next[board[row][col] - 'a'] == null) return;
        char letter = board[row][col];
        node = node.next[letter - 'a'];
        if (node.word != null) {
            results.add(node.word);
            node.word = null;
        }
        board[row][col] = '0';
        backtrack(board, node, results, row - 1, col);
        backtrack(board, node, results, row + 1, col);
        backtrack(board, node, results, row, col - 1);
        backtrack(board, node, results, row, col + 1);
        board[row][col] = letter;
    }
}

class Solution {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd = false;
        private String word; // Store the actual word at end nodes

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

        public void setEnd(String word) {
            isEnd = true;
            this.word = word;
        }

        public boolean isEnd() {
            return isEnd;
        }
        
        public String getWord() {
            return word;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd(word);
        }
        
        public TrieNode getRoot() {
            return root;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.getRoot(), visited, result);
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, 
                     boolean[][] visited, Set<String> result) {
        // Check boundaries and visited status
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        char c = board[i][j];
        
        // Check if current character exists in Trie
        if (!node.containsKey(c)) {
            return;
        }
        
        // Move to the next node
        node = node.get(c);
        
        // If we found a word, add it to result
        if (node.isEnd()) {
            result.add(node.getWord());
        }
        
        // Mark current cell as visited
        visited[i][j] = true;
        
        // Explore all 4 directions
        dfs(board, i + 1, j, node, visited, result); // down
        dfs(board, i - 1, j, node, visited, result); // up
        dfs(board, i, j + 1, node, visited, result); // right
        dfs(board, i, j - 1, node, visited, result); // left
        
        // Backtrack: unmark the current cell
        visited[i][j] = false;
    }
}
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
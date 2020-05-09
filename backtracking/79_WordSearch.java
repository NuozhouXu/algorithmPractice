class Solution { 
    // O(N * 4^L) where N is the number of cells in the board and L is the length of the word to be matched.
    // O(L) space
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index >= word.length()) {
            return true;
        }
        
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(index)) return false;
        
        boolean ret = false;
        char temp = board[row][col];
        board[row][col] = '0';
        
        ret = backtrack(board, word, row, col - 1, index + 1) ||
            backtrack(board, word, row - 1, col, index + 1) || 
            backtrack(board, word, row, col + 1, index + 1) || 
            backtrack(board, word, row + 1, col, index + 1);
        
        board[row][col] = temp;
        return ret;
    }
}
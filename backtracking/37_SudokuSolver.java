class Solution {
    // O((9!)^9) time
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }
    
    private boolean backtrack(char[][] board, int currIndex) {
        while (currIndex < 81 && board[currIndex / 9][currIndex % 9] != '.') currIndex++; 
        if (currIndex == 81) {
          return true;
        } else {
          int row = currIndex / 9;
          int col = currIndex % 9;
          Set<Character> candidates = findCandidates(board, row, col);
          for (Character candidate: candidates) {
            board[row][col] = candidate;
            boolean found = backtrack(board, currIndex + 1);
            if (found) return true;
            board[row][col] = '.';
          }
          return false;
        }
    }
    
    private Set<Character> findCandidates(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (char c = '1'; c <= '9'; c++) set.add(c);
        for (int i = 0; i < 9; i++) {
            if (set.contains(board[row][i])) set.remove(board[row][i]);
            if (set.contains(board[i][col])) set.remove(board[i][col]);
            if (set.contains(board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3])) set.remove(board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3]);
        }
        return set;
    }
}
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(board.length - i - 1, board[0].length - 1, board);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(0, board[0].length - i - 1, board);
            dfs(board.length - 1, i, board);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(int row, int col, char[][] board) {
        if (board[row][col] != 'O') return;
        
        board[row][col] = 'E';
        if (row > 0) {
            dfs(row - 1, col, board);
        }
        if (row < board.length - 1) {
            dfs(row + 1, col, board);
        }
        if (col > 0) {
            dfs(row, col - 1, board);
        }
        if (col < board[0].length - 1) {
            dfs(row, col + 1, board);
        }
    }
}
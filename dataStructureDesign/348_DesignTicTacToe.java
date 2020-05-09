class TicTacToe {
    
    private int n;
    private int[] rows;
    private int[] cols;
    private int diagonalTopLeftToBottomRight;
    private int diagonalTopRightToBottomLeft;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonalTopLeftToBottomRight = 0;
        this.diagonalTopRightToBottomLeft = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += player == 1 ? 1 : -1;
        cols[col] += player == 1 ? 1 : -1;
        if (row == col) diagonalTopLeftToBottomRight += player == 1 ? 1 : -1;
        if (row + col == n - 1) diagonalTopRightToBottomLeft += player == 1 ? 1 : -1;
        if (rows[row] == n || cols[col] == n || diagonalTopLeftToBottomRight == n || diagonalTopRightToBottomLeft == n) return 1;
        if (rows[row] == -n || cols[col] == -n || diagonalTopLeftToBottomRight == -n || diagonalTopRightToBottomLeft == -n) return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
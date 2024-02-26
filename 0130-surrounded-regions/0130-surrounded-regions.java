class Solution {
    public void solve(char[][] board) {
        // Three things: 1. Capture unsurrounded area, dfs
        // 2. Iterate and flip o to x
        // 3. Flip t to o

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        if ((i < 0 || i >= board.length || j < 0 || j >= board[i].length)) {
            return;
        }
        if(board[i][j]!='O')
        {
            return;
        }

        board[i][j] = 'T';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);

    }

}
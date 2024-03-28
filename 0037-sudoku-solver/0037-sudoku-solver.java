class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int z = 1; z <= 9; z++) {
                        if (isValid(board, z, i, j)) {
                            board[i][j] = (z + "").charAt(0);
                            boolean res = dfs(board);
                            if (res) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int z, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == (z + "").charAt(0)) {
                return false;
            }
            if (board[i][c] == (z + "").charAt(0)) {
                return false;
            }
            if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == (z + "").charAt(0)) {
                return false;
            }

        }
        return true;
    }
}
class Solution {
    public void solve(char[][] board) {
        Set<Pair> visited = new HashSet<>();
        // Here we go to all the boarder and see if the zero is on boarder and an other
        // zero is
        // adjacent to it
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                    if(board[i][j]=='O')
                    dfs(board, i, j, visited);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, Set<Pair> visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        Pair pair = new Pair(i, j);
        if(visited.contains(pair))
        {
            return;
        }
     
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        visited.add(pair);
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }

}
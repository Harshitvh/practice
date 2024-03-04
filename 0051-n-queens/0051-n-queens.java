class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pos = new HashSet<>();
        Set<Integer> neg = new HashSet<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(0, res, board, cols, pos, neg);
        return res;
    }

    private void dfs(int n, List<List<String>> res, char[][] board,
            Set<Integer> cols, Set<Integer> pos, Set<Integer> neg) {
        if (n == board.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(String.valueOf(board[i]));
            }
            res.add(temp);
        }
        for (int i = 0; i < board.length; i++) {
            int r = n;
            int c = i;
            if (cols.contains(c) || neg.contains(r + c) || pos.contains(r - c)) {
                continue;
            }
            board[r][c] = 'Q';
            cols.add(c);
            pos.add(r - c);
            neg.add(r + c);
            dfs(n + 1, res, board, cols, pos, neg);
            board[r][c]='.';
            cols.remove(c);
            pos.remove(r - c);
            neg.remove(r + c);
        }
        return;
    }
}
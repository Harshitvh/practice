class Solution {
    List<Integer> res = new LinkedList<>();

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pos = new HashSet<>();
        Set<Integer> neg = new HashSet<>();
        int count = dfs(0, board, cols, pos, neg, 0);
        return count;
    }

    private int dfs(int n, char[][] board,
            Set<Integer> cols, Set<Integer> pos, Set<Integer> neg, int count) {
        if (n == board.length) {
            count = count + 1;
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
            count = dfs(n + 1, board, cols, pos, neg, count);
            board[r][c] = '.';
            cols.remove(c);
            pos.remove(r - c);
            neg.remove(r + c);
        }
        return count;
    }
}
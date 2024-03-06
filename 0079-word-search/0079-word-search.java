class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Pair<Integer, Integer>> visiting = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = dfs(0, board, i, j, word, visiting);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, char[][] board, int r, int c, String word,
            Set<Pair<Integer, Integer>> visiting) {
        if (i == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) {
            return false;
        }
        char v = board[r][c];
        if (visiting.contains(new Pair(r, c)) || board[r][c] != word.charAt(i)) {
            return false;
        }
        visiting.add(new Pair(r, c));
        boolean res = (dfs(i + 1, board, r + 1, c, word, visiting) ||
                dfs(i + 1, board, r, c + 1, word, visiting) ||
                dfs(i + 1, board, r - 1, c, word, visiting) ||
                dfs(i + 1, board, r, c - 1, word, visiting));
        visiting.remove(new Pair(r,c));
        return res;
    }
}
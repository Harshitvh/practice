class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> box = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int r = i;
                int c = j;
                Character v = board[i][j];
                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                int a = r / 3;
                int b = c / 3;
                box.putIfAbsent(a + "" + b, new HashSet<>());
                if (v == '.') {
                    continue;
                }
                if (rows.get(r).contains(v)) {
                    return false;
                }
                rows.get(r).add(v);
                if (cols.get(c).contains(v)) {
                    return false;
                }
                cols.get(c).add(v);
                if (box.get(a + "" + b).contains(v)) {
                    return false;
                }
                box.get(a + "" + b).add(v);
            }
        }
        return true;

    }
}
class Solution {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean eos = false;

        public TrieNode() {
            this.map = new HashMap<>();
            this.eos = false;
        }
    }

    private TrieNode root = new TrieNode();

    private void addNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.map.containsKey(word.charAt(i))) {
                current.map.put(word.charAt(i), new TrieNode());
            }
            current = current.map.get(word.charAt(i));
        }
        current.eos = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (String word : words) {
            addNode(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, board, "", visited, root, res);
            }
        }
        List<String> result = new LinkedList<>();
        result.addAll(res);
        return result;
    }

    private void dfs(int i, int j, char[][] board, String start, Set<Pair<Integer, Integer>> visited,
            TrieNode node, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        Pair<Integer, Integer> p = new Pair(i, j);
        if (visited.contains(p)) {
            return;
        }
        if (!node.map.containsKey(board[i][j])) {
            return;
        }
        visited.add(p);
        start = start + "" + board[i][j];
        node = node.map.get(board[i][j]);
        if (node.eos) {
            res.add(start);
        }
        dfs(i + 1, j, board, start, visited, node, res);
        dfs(i - 1, j, board, start, visited, node, res);
        dfs(i, j + 1, board, start, visited, node, res);
        dfs(i, j - 1, board, start, visited, node, res);
        visited.remove(p);
    }
}
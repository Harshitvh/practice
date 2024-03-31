class Solution {
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited.add(new Pair(i, j));
                }
            }
        }
        int count = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int z = 0; z < len; z++) {
                Pair<Integer, Integer> pop = q.removeFirst();
                int i = pop.getKey();
                int j = pop.getValue();
                List<Pair<Integer, Integer>> nbors = getNbors(i, j, mat, visited);
                System.out.println("11he");

                for (Pair<Integer, Integer> n : nbors) {
                    System.out.println("he");
                    int r = n.getKey();
                    int c = n.getValue();
                    res[r][c] = count;
                    visited.add(new Pair(r, c));
                    q.add(new Pair(r, c));
                }
            }
            count++;
        }

        return res;
    }

    private List<Pair<Integer, Integer>> getNbors(int i, int j, int[][] mat, Set<Pair<Integer, Integer>> visited) {
        List<Pair<Integer, Integer>> res = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && !visited.contains(new Pair(r, c))) {
                if (mat[r][c] != 0) {
                    res.add(new Pair(r, c));
                }
            }
        }
        return res;
    }
}
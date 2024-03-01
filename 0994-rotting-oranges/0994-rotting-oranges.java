class Solution {
    private int fresh = 0;

    public int orangesRotting(int[][] grid) {
        Set<Pair> visited = new HashSet<>();
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh = fresh + 1;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int z = 0; z < len; z++) {
                Pair<Integer, Integer> pop = q.removeFirst();
                List<Pair> nbors = getNbors(pop.getKey(), pop.getValue(), grid);
                nbors.forEach(n -> q.add(n));
            }
            count = count + 1;

        }

        return fresh == 0 ? count : -1;
    }

    public List<Pair> getNbors(int r, int c, int[][] grid) {
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        List<Pair> res = new ArrayList<>();
        for (int z = 0; z < dirs.length; z++) {
            int i = r + dirs[z][0];
            int j = c + dirs[z][1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
                Pair pair = new Pair(i, j);
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    res.add(pair);
                    fresh = fresh - 1;
                }

            }
        }
        return res;
    }
}
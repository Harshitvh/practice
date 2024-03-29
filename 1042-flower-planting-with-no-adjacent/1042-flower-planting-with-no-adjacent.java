class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = buildGraph(paths);
        int[] result = new int[n];
        dfs(1, result, graph, n);
        return result;
    }

    private boolean dfs(int garden, int[] res, Map<Integer, List<Integer>> graph, int n) {
        if (garden > n) {
            return true;
        }
        for (int i = 1; i <= 4; i++) {
            if (canPaint(garden, graph, i, res)) {
                res[garden - 1] = i;
                boolean b1 = dfs(garden + 1, res, graph, n);
                if (b1) {
                    return true;
                } else {
                    res[garden - 1] = 0;
                }
            }
        }
        return false;
    }

    private boolean canPaint(int garden, Map<Integer, List<Integer>> graph, int paint, int[] res) {
        List<Integer> nbors = graph.get(garden)!=null ?graph.get(garden) : new ArrayList<>();
        for (Integer nbor : nbors) {
            if (res[nbor - 1] == paint) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            int a1 = paths[i][0];
            int a2 = paths[i][1];

            map.putIfAbsent(a1, new ArrayList<>());
            map.putIfAbsent(a2, new ArrayList<>());

            map.get(a1).add(a2);
            map.get(a2).add(a1);

        }
        return map;
    }
}
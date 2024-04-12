class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            if (!bfs(i, graph, map)) {
                return false;
            }
        }
        return true;

    }

    private boolean bfs(int i, int[][] graph, Map<Integer, Integer> map) {
        if (map.containsKey(i)) {
            return true;
        }
        LinkedList<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int pop = q.removeFirst();
            int[] nbors = graph[pop];
            for (int n : nbors) {
                if (map.containsKey(n)) {
                    Integer popc = map.get(pop);
                    int color = map.get(n);
                    if (popc == null) {
                        if (color == 0) {
                            map.put(pop, 1);
                        } else {
                            map.put(pop, 0);
                        }
                    } else if (popc == color) {
                        return false;
                    }
                } else {
                    q.add(n);
                }
            }
            if (!map.containsKey(pop)) {
                map.put(pop, 1);
            }
        }
        return true;
    }
}
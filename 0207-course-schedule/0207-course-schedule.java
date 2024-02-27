class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = buildGraph(prerequisites);
        int sum = 0;
        for (Integer key : map.keySet()) {
            if (!bfs(key, map))
                return false;
        }
        return true;
    }

    public boolean bfs(Integer key, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        visited.add(key);
        q.add(key);
        while (!q.isEmpty()) {
            Integer pop = q.removeFirst();
            List<Integer> nbors = graph.get(pop);
            for (Integer n : nbors) {
                if (n == key) {
                    return false;
                }
                if (!visited.contains(n)) {
                    q.add(n);
                    visited.add(n);
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] reqs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < reqs.length; i++) {
            int f = reqs[i][0];
            int s = reqs[i][1];
            map.putIfAbsent(f, new ArrayList<>());
            map.putIfAbsent(s, new ArrayList<>());
            map.get(f).add(s);
        }
        return map;
    }
}
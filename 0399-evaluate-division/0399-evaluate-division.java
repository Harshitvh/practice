class Solution {
    class Node {
        String key;
        /// Value will be the edge
        double value;

        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());

        }
        return result;
    }

    // Using bfs
    public double bfs(String s, String d, Map<String, List<Node>> graph, Set<String> visited) {
        LinkedList<Node> q = new LinkedList<>();
        if (!(graph.containsKey(s) && graph.containsKey(d))) {
            return -1.0;
        }
        if (s.equals(d))
            return 1.0;
        visited.add(s);
        q.add(new Node(s, 1));
        while (!q.isEmpty()) {
            Node popd = q.removeFirst();
            String temp = popd.key;
            double w = popd.value;
            List<Node> nbors = graph.get(temp);
            for (Node n : nbors) {
                if (n.key.equals(d)) {
                    return w * n.value;
                }
                if (!visited.contains(n.key)) {
                    q.add(new Node(n.key, w * n.value));
                    visited.add(n.key);
                }
            }
        }
        return -1.0;
    }

    public Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            g.putIfAbsent(src, new ArrayList<>());
            g.putIfAbsent(des, new ArrayList<>());
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1 / values[i]));
        }
        return g;
    }
}
class Solution {
    class Node{
        String key;
        ///Value will be the edge
        double value;

        public Node(String key, double value)
        {
           this.key=key;
           this.value=value;
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i=0;i<result.length;i++)
        {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());

        }
        return result;
    }

 public double dfs(String s, String d,Map<String, List<Node>> graph ,Set<String> visited) {
        if(!(graph.containsKey(s) && graph.containsKey(d))) {
            return -1.0;
        }
        if(s.equals(d)) return 1.0;
        visited.add(s);
        for(Node ng: graph.get(s)) {
            if(!visited.contains(ng.key)) {
                double ans = dfs(ng.key,d,graph,visited);
                if(ans!= -1.0) {
                    return ans*ng.value;
                }
            }
        }
       return -1.0;
    }

    public Map<String,List<Node>> buildGraph(List<List<String>> eq,double[] values) {
        Map<String,List<Node>> g = new HashMap<>();
        for(int i = 0; i < values.length;i++) {
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            g.putIfAbsent(src,new ArrayList<>());
            g.putIfAbsent(des, new ArrayList<>());
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src,1/values[i]));
        }
        return g;
    }
}
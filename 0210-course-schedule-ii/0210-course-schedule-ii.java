class Solution {
    List<Integer> res = new ArrayList<>();

    //This is getting solved using the dfs, but here the thing is 
    //we need to maintain another set called as visiting, to 
    //check whethert we end up getting into a loop
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = buildGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            boolean res = dfs(i, visited, visiting, map);
            if (!res)
                return new int[0];
        }
        int[] r = new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            r[i]= res.get(i);
        }
        return r;
    }

    private boolean dfs(int i, Set<Integer> visited, Set<Integer> visiting,
            Map<Integer, List<Integer>> map) {
        if (visiting.contains(i)) {
            return false;
        }
        if (visited.contains(i)) {
            return true;
        }

        List<Integer> nbors = map.get(i) != null ? map.get(i) : new ArrayList<>();
        visiting.add(i);
        for (int z = 0; z < nbors.size(); z++) {
          boolean res = dfs(nbors.get(z), visited,visiting,map);
          if(!res)
          {
              return false;
          }
        }
        visiting.remove(i);
        visited.add(i);
        res.add(i);
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] reqs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < reqs.length; i++) {

            int f = reqs[i][0];
            int s = reqs[i][1];
            map.putIfAbsent(f, new LinkedList<>());
            map.putIfAbsent(s, new LinkedList<>());
            map.get(f).add(s);

        }
        return map;
    }

}
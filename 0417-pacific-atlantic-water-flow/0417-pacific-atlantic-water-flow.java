class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
     Set<Pair> atl = new HashSet<>();
     Set<Pair> paf = new HashSet<>();
     List<List<Integer>> res = new ArrayList<>();
     for(int i=0;i<heights.length;i++)
     {
         dfs(i, heights[i].length-1, atl, heights,0);
         dfs(i, 0, paf, heights,0);
     }
       for(int j=0;j<heights[0].length;j++)
     {
         dfs(0, j, paf, heights,0);
         dfs(heights.length-1, j, atl, heights,0);
     }
     for(int i=0;i<heights.length;i++)
     {
         for(int j=0;j<heights[i].length;j++)
         {
             Pair pair = new Pair(i,j);
             if(atl.contains(pair) && paf.contains(pair))
             {
                 res.add(List.of(i,j));
             }
         }
     }
     return res;
    }

    private void dfs(int r, int c, Set<Pair> set, int[][] arr, int prev) {
        Pair pair = new Pair(r, c);
        if (set.contains(pair)) {
            return;
        }
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[r].length) {
            return;
        }
        int value = arr[r][c];
        if (value < prev) {
            return;
        }
        set.add(new Pair(r,c));
        dfs(r, c + 1, set, arr, value);
        dfs(r, c - 1, set, arr, value);
        dfs(r+1, c  , set, arr, value);
        dfs(r-1, c , set, arr, value);

    }

}
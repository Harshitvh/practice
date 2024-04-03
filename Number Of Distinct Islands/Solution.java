class Solution {

    int countDistinctIslands(int[][] grid) {
       Set<List<String>> res = new HashSet<>();
       Set<String> visited = new HashSet<>();
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[i].length;j++)
           {
               if(grid[i][j]==1 && !visited.contains(i + ""+j))
               {
                   List<String> temp = new ArrayList<>();
                   dfs(i,j,grid,temp, visited, i,j);
                   res.add(temp);
               }
           }
       }
       
       return res.size();
    }
    
    private void dfs(int i, int j, int[][] grid, List<String> temp, Set<String> visited, int ib,int  jb)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length)
        {
            return;
        }
        if(visited.contains(i+""+j))
        {
            return;
        }
        if(grid[i][j]!=1)
        {
            return ;
        }
        visited.add(i+""+j);
        temp.add(new String((i-ib) + ""+(j-jb)));
        dfs(i+1, j, grid, temp, visited, ib,jb);
        dfs(i-1, j, grid, temp, visited, ib, jb);
        dfs(i, j+1, grid, temp, visited, ib, jb);
        dfs(i, j-1, grid, temp, visited, ib, jb);
    }
}

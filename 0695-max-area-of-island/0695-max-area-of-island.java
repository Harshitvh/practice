class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
               if(grid[i][j]==1 && !visited.contains(i+" "+j))
               {
                   int temp = dfsCount(grid,i,j,visited,0);
                   count = Math.max(temp, count);
               }
            }
        }
        return count;    
    }

    public int dfsCount(int[][] grid, int r, int c, Set<String> visited, int count)
    {
        if(r<0 || r>=grid.length||c<0||c>=grid[r].length)
        {
           return count; 
        }
        if(visited.contains(r +" "+c))
        {
            return count;
        }
        if(grid[r][c]!=1)
        {
           return count;
        }
        count = count +1;
        visited.add(r+" "+c);
        count = dfsCount(grid,r-1,c,visited,count);
        count = dfsCount(grid, r+1, c, visited, count);
        count = dfsCount(grid, r, c+1, visited, count);
        count = dfsCount(grid, r, c-1, visited, count);
        return count;
    }


}
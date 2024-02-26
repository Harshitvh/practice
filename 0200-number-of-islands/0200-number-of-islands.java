class Solution {
    class Index {
        int i;
        int j;

        @Override
        public boolean equals(Object o) {
            Index idx = (Index) o;
            return this.i == idx.i && this.j == idx.j;
        }

          @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int numIslands(char[][] grid) {
        //This is a bfs approach, just for learning
        Set<Index> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && isNotVisited(i, j, visited)) {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, char[][] grid, Set<Index> visited)
    {
        LinkedList<Index> q = new LinkedList<>();
        Index idx = new Index();
        idx.i = i;
        idx.j = j;
        visited.add(idx);
        q.add(idx);
        while(!q.isEmpty())
        {
            Index poped = q.removeFirst();
            List<Index> nbors = getNeighbours(poped.i,poped.j,grid,visited);
            q.addAll(nbors);
            visited.addAll(nbors);
        }
    }

    public List<Index> getNeighbours(int r, int c, char[][] grid, Set<Index> visited)
    {
        List<Index> nbors = new ArrayList<>();
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int i=0;i<dirs.length;i++)
        {

                int row = dirs[i][0]+r;
                int col = dirs[i][1] +c;
                if(row>=0 && row<grid.length && col>=0 && col<grid[row].length)
                {
                    char value = grid[row][col];
                    if(value=='1' && isNotVisited(row, col, visited))
                    {
                        Index idx = new Index();
                        idx.i = row;
                        idx.j = col;
                        nbors.add(idx);
                    }
                }

        }
        return nbors;
    }

    public boolean isNotVisited(int i, int j, Set<Index> visited) {
        Index idx = new Index();
        idx.i = i;
        idx.j = j;
        return !visited.contains(idx);
    }
}
class Solution {
    public int findCircleNum(int[][] nums) {
        int count = nums.length;
        int[] rank = new int[nums.length];
        int[] parent = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            parent[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i != j) {
                    if (nums[i][j]==1)
                        count = count - union(i, j, parent, rank);
                }
            }
        }
        return count;
    }

    public int find(int x, int[] parent) {
        int par = parent[x];
        while (par != parent[par]) {
            par = parent[parent[par]];
            par = parent[par];
        }
        return par;
    }

    public int union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) {
            return 0;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX] += 1;
        }
        return 1;
    }
}
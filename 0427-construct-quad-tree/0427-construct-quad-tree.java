/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return cons(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node cons(

            int[][] grid,
            int i1,
            int i2,
            int j1,
            int j2) {
        int val = check(grid, i1, i2, j1, j2);
        if (val != -1) {
            Node node = new Node();
            node.val = val == 1 ? true : false;
            node.isLeaf = true;
            return node;
        }
        Node node = new Node();
        node.val = grid[i1][j1] == 1 ? true : false;
        int midi = i1 + (i2 - i1) / 2;
        int midj = j1 + (j2 - j1) / 2;
        node.topLeft = cons(grid, i1, midi, j1, midj);
        node.topRight = cons(grid, i1, midi, midj + 1, j2);
        node.bottomLeft = cons(grid, midi + 1, i2, j1, midj);
        node.bottomRight = cons(grid, midi + 1, i2, midj + 1, j2);
        node.isLeaf = false;
        return node;
    }

    private int check(int[][] grid, int i1, int i2, int j1, int j2) {
        int val = grid[i1][j1];
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (val != grid[i][j]) {
                    return -1;
                }
            }
        }
        return val;
    }
}
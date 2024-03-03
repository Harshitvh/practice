/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode,Integer>> q = new LinkedList<>();
        int max = 1;
        q.add(new Pair(root, 1));
        while (!q.isEmpty()) {
            max = Math.max(max, bfs(q));
        }
        return max;
    }

    private int bfs(LinkedList<Pair<TreeNode,Integer>> q) {
        int len = q.size();
        int c = 0;
        Pair<TreeNode, Integer> p1 = q.getFirst();
        Pair<TreeNode, Integer> p2 = q.getLast();
        while (c < len) {
            Pair<TreeNode, Integer> parent = q.removeFirst();
            TreeNode node = parent.getKey();
            Integer value = parent.getValue();
            if(node.left!=null)
            {
                q.add(new Pair(node.left, (2*value)));
            }
             if(node.right!=null)
            {
                q.add(new Pair(node.right, (2*value)+1));
            }
        
            c++;
        }
        return p2.getValue()-p1.getValue()+1;

    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return List.of(root.val);
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(bfs(q).val);
        }
        return res;
    }

    public TreeNode bfs(LinkedList<TreeNode> q) {
        int len = q.size();
        int c = 0;
        TreeNode node = null;

        while (c < len) {
            node = q.removeFirst();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            c++;
        }
        return node;
    }

}
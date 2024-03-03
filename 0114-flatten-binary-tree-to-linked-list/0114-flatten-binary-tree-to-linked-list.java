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
    public void flatten(TreeNode root) {
        flattenR(root);
    }

    public TreeNode flattenR(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode flatLeft = flattenR(root.left);
        TreeNode flatRight = flattenR(root.right);

        if (root.left != null) {
            flatLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //Always remember to return the flatRight first
        if (flatRight != null) {
            return flatRight;
        }
        if (flatLeft != null) {
            return flatLeft;
        }

        return root;
    }
}
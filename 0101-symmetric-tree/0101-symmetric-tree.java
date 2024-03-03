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
    public boolean isSymmetric(TreeNode root) {
        return isR(root.left, root.right);
    }

    public boolean isR(TreeNode left, TreeNode right) {
        if(left==right && right==null)
        {
            return true;
        }
        if(left==null && right!=null)
        {
            return false;
        }
        if(right==null && left!=null)
        {
            return false;
        }
        if(right.val != left.val)
        {
            return false;
        }
        boolean s1 = isR(left.left, right.right);
        boolean s2 = isR(left.right, right.left);

        return s1 && s2;

     }
}
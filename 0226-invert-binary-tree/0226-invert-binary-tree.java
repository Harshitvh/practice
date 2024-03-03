/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
         dfs(root);
         return root;
    }

    private void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==root.right && root.left==null)
        {
            return;
        }
        if(root.left==null && root.right!=null)
        {
            root.left = root.right;
            root.right = null;
        }
        else if(root.right==null && root.left!=null)
        {
            root.right = root.left;
            root.left = null;
        }
        else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        dfs(root.right);
        dfs(root.left);
    }
}
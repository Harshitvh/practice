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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return hasPathSumR(root, targetSum);
    }

    public boolean hasPathSumR(TreeNode root, int target)
    {
        if(root==null)
        {
            return false;
        }
        if(root.right==root.left && root.left==null)
        {
            return target==root.val;
        }
        if(root.left!=null)
        {
            if(root.val+root.left.val==target && isChild(root.left))
            {
                return true;
            }
        }
         if(root.right!=null)
        {
            if(root.val+root.right.val==target && isChild(root.right))
            {
                return true;
            }
        }
        boolean left = hasPathSumR(root.left, target-root.val);
        boolean right = hasPathSumR(root.right, target-root.val);
        return left||right;
     }

    private boolean isChild(TreeNode root)
    {
        return root.left==null && root.right==null;
    }
}
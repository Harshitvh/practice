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
    private Integer count =1;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    public int inorder(TreeNode root, int k)
    {
        if(root==null)
        {
            return -1;
        }
        int valueLeft = inorder(root.left, k);
        if(valueLeft!=-1)
        {
            return valueLeft;
        }
        if(count==k)
        {
            return root.val;
        }
        count++;
        int valueRight = inorder(root.right, k);
        if(valueRight!=-1)
        {
            return valueRight;
        }
        return -1;
    }
}
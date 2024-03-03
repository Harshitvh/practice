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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);

    }

    private int dfs(TreeNode root, int max) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            count=count+1;
        }
        max = Math.max(max,root.val);
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        return count + left+right;
    }
}
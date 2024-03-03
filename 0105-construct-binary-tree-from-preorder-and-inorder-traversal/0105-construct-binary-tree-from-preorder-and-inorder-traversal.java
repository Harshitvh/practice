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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeR(preorder, inorder);
    }

    public TreeNode buildTreeR(int[] preorder, int[] inorder)
    {
        TreeNode root;
        if(inorder.length==0 || preorder.length==0)
        {
            return null;
        }
        root =  new TreeNode(preorder[0]);
        int mid = find(inorder, preorder[0]);
        root.left = buildTreeR(Arrays.copyOfRange(preorder, 1, mid+1),
                                Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTreeR(Arrays.copyOfRange(preorder, mid+1, preorder.length),
                                Arrays.copyOfRange(inorder, mid+1, inorder.length));
        return root;
    }

    private int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
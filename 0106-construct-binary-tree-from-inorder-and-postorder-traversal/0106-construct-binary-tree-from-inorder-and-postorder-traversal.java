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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<postorder.length;i++)
       {
           stack.push(postorder[i]);
       }
      return buildTreeR(inorder, stack); 
    }

    public TreeNode buildTreeR(int[] inorder, Stack<Integer> postorder) {
        if ( inorder.length == 0) {
            return null;
        }
        int rootI = postorder.pop();
        TreeNode root = new TreeNode(rootI);
        int idx = find(inorder, rootI);
        root.right = buildTreeR(Arrays.copyOfRange(inorder, idx+1, inorder.length),
                                postorder);
        root.left = buildTreeR(Arrays.copyOfRange(inorder,0,idx), postorder);
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
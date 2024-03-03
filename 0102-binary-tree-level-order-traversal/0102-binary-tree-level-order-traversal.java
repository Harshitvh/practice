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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root==null)
        {
            return new ArrayList<>();
        }

        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> temp = bfs(q);
            res.add(temp);
        }
        return res;
     }

     public List<Integer> bfs(LinkedList<TreeNode> q)
     {
         int len = q.size();
         int count = 0;
         List<Integer> res = new ArrayList<>();
         while(count<len)
         {
             TreeNode removed = q.removeFirst();
             res.add(removed.val);
             if(removed.left!=null)
             {
                 q.add(removed.left);
             }
             if(removed.right!=null)
             {
                 q.add(removed.right);
             }
             count++;
         }
         return res;
     }

   
}
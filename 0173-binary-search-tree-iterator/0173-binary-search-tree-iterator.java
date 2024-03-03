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
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        while(current!=null)
        {
            stack.push(current);
            current= current.left;
        }
    }

    public int next() {
        if(!stack.isEmpty())
        {
            TreeNode pop = stack.pop();
            TreeNode current = pop.right;
            while(current!=null)
            {
                stack.push(current);
                current = current.left;
            }
            return pop.val;
        }
        return -1;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
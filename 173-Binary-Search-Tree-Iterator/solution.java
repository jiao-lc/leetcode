/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<TreeNode> arr = new ArrayList<TreeNode>();
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.empty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            arr.add(root);
            root = root.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return arr.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = arr.remove(0);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
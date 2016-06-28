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
    TreeNode current;
    public BSTIterator(TreeNode root) {
        if(root == null)    return;
        current = root;
        while(current.left != null) {
            current = current.left;
        }
        reconstruct(root);
    }
    
    public void reconstruct(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                if(pre != null) pre.right = cur;
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while(tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if(tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = cur;
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = current.val;
        current = current.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
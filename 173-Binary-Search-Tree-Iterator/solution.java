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
TreeNode nodeIterator;
public BSTIterator(TreeNode root) {
    TreeNode node = root;
    if (root == null) return;
    while (node.left != null) {
        node = node.left;
    }
    nodeIterator = node;
    restructure(root);
}

/** @return whether we have a next smallest number */
public boolean hasNext() {
    return nodeIterator != null;
}

/** @return the next smallest number */
public int next() {
    int next = nodeIterator.val;
    nodeIterator = nodeIterator.right;
    return next;
}

private void restructure(TreeNode node) {
    TreeNode pre = null;
    TreeNode temp = null;
    while(node!=null){
        if(node.left!=null){
            // connect threading for node
            temp = node.left;
            while(temp.right!=null && temp.right != node)
                temp = temp.right;
            // the threading already exists
            if(temp.right != null){
                // add right pointer from 'pre' node to current node
                pre.right = node;
                pre = node;
                node = node.right;
            }else{
                // construct the threading
                temp.right = node;
                node = node.left;
            }
        }else{
            // add right pointer from 'pre' node to current node
            if (pre != null) pre.right = node;
            pre = node;
            node = node.right;
        }
    }
}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
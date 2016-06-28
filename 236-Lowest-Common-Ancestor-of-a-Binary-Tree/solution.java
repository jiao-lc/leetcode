/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isAncestor(root.left, p) && isAncestor(root.left, p)) return lowestCommonAncestor(root.left, p, q);
        else if(isAncestor(root.right, p) && isAncestor(root.right, p)) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
    
    public boolean isAncestor(TreeNode root, TreeNode p) {
        if(root == p)   return true;
        return isAncestor(root.left, p) || isAncestor(root.right, p);
    }
}
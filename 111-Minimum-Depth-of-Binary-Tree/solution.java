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
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        return helper(root);
    }
    public int helper(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null)
            left = minDepth(root.left);
        if(root.right != null)
            right = minDepth(root.right);
        return 1 + Math.min(left, right);
    }
}
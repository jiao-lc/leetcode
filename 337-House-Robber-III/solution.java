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
    public int rob(TreeNode root) {
        if(root == null)    return 0;
        int res = root.val;
        return Math.max(res + robChild(root.left) + robChild(root.right), robChild(root));
    }
    
    public int robChild(TreeNode root) {
        if(root == null)    return 0;
        return rob(root.left) + rob(root.right);
    }
}
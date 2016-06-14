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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)    return res;
        helper(res, root);
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode root) {
        res.add(root.val);
        if(root.left != null)   helper(res, root.left);
        if(root.right != null)  helper(res, root.right);
    }
}
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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int ans = calculate(0, root);
        return ans;
    }
    
    public int calculate(int val, TreeNode root) {
        int ans = val * 10 + root.val;
        if(root.left == null && root.right == null) {
            return ans;
        }
        return calculate(ans, root.left) + calculate(ans, root.right);
    }
}
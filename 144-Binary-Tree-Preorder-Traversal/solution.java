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
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.empty() || root != null) {
            if(root != null) {
                res.add(root.val);
                s.push(root.right);
                s.push(root.left);
                root = s.pop();
            } else {
                while(!s.empty() && root == null)   root = s.pop();
            }
        }
        
        return res;
    }
    
}
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
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0, res = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while((!stack.empty() || root != null) && cnt < k) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res = root.val;
            cnt++;
            root = root.right;
        }
        return res;
    }
}
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        helper(root.left, sum-root.val, path, res);
        helper(root.right, sum-root.val, path, res);
        // backtracking
        path.remove(path.size()-1);
    }
}
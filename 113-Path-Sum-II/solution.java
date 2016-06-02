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
        helper(res, new ArrayList<Integer>(), sum, root);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int sum, TreeNode root) {
        list.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(new ArrayList(list));
            }
            return;
        }
        if(root.left != null) {
            helper(res, list, sum, root.left);
        }
        if(root.right != null) {
            helper(res, list, sum, root.right);
        }
    }
}
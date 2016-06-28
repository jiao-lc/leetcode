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
        List<Integer> arr = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while((!stack.empty() || root != null) && arr.size() < k) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            arr.add(root.val);
            root = root.right;
        }
        return arr.get(k - 1);
    }
}
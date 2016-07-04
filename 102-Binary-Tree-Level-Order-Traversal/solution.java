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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.peek() != null) {
            Queue<TreeNode> tmp = new LinkedList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while(queue.peek() != null) {
                root = queue.poll();
                list.add(root.val);
                if(root.left != null)   tmp.add(root.left);
                if(root.right != null)  tmp.add(root.right);
            }
            queue = tmp;
            res.add(list);
        }
        return res;
    }
}
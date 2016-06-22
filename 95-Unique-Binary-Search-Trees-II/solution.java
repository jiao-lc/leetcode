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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n == 0)  return res;
        res = getTreeNode(1, n);
        return res;
    }
    
    public List<TreeNode> getTreeNode(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> lefttree = getTreeNode(start, i - 1);
            List<TreeNode> righttree = getTreeNode(i + 1, end);
            if(lefttree == null) {
                for(TreeNode node : righttree) {
                    TreeNode root = new TreeNode(i);
                    root.right = node;
                    res.add(root);
                }
            }
            if(righttree == null) {
                for(TreeNode node : lefttree) {
                    TreeNode root = new TreeNode(i);
                    root.left = node;
                    res.add(root);
                }
            }
            if(lefttree != null && righttree != null) {
                for(TreeNode l : lefttree) {
                    for(TreeNode r : righttree) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
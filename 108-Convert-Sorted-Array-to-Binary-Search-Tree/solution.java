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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }
    public TreeNode convertToBST(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end)    return new TreeNode(nums[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToBST(nums, start, mid - 1);
        root.right = convertToBST(nums, mid + 1, end);
        return root;
    }
}
public class Solution {
    class Node {
        Node left, right;
        int val, count = 1; //leftCnt recording the total of number on it's left bottom side, dup counts the duplication.
        public Node(int v) {
            this.val = v;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0)    return res;
        Node root = new Node(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int cnt = insertNode(root, nums[i]);
            res.add(0, cnt);
        }
        return res;
    }
    public int insertNode(Node root, int val) {
        int thisCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;
                if(root.left == null) {
                    root.left = new Node(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new Node(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }
}
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        long [] sum = new long[nums.length+1];
        for(int i = 1; i<sum.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        TreeNode root = new TreeNode(sum[0]);
        for(int i = 1; i<sum.length; i++){
            res += rangeSize(root, sum[i]-upper, sum[i]-lower);
            insert(root, sum[i]);
        }
        return res;
    }
    
    private TreeNode insert(TreeNode root, long val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val == val){
            root.count++;
        }else if(root.val > val){
            root.leftSize++;
            root.left = insert(root.left, val);
        }else if(root.val < val){
            root.rightSize++;
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    private int countSmaller(TreeNode root, long val){
        if(root == null){
            return 0;
        }
        if(root.val == val){
            return root.leftSize;
        }else if(root.val > val){
            return countSmaller(root.left, val);
        }else{
            return root.leftSize + root.count + countSmaller(root.right, val);
        }
    }
    
    private int countLarget(TreeNode root, long val){
        if(root == null){
            return 0;
        }
        if(root.val == val){
            return root.rightSize;
        }else if(root.val > val){
            return countLarget(root.left, val) + root.count + root.rightSize;
        }else{
            return countLarget(root.right, val);
        }
    }
    
    private int rangeSize(TreeNode root, long lower, long upper){
        int total = root.leftSize + root.count + root.rightSize;
        int smaller = countSmaller(root, lower);
        int larger = countLarget(root, upper);
        return total - smaller - larger;
    }
}

class TreeNode{
    long val;
    int count;
    int leftSize;
    int rightSize;
    TreeNode left;
    TreeNode right;
    public TreeNode(long val){
        this.val = val;
        this.count = 1;
        this.leftSize = 0;
        this.rightSize = 0;
    }
}
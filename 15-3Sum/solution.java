public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0)    return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1]))
                helper(res, nums, nums[i], i + 1, nums.length - 1);
        }
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, int target, int start, int end) {
        if(start >= end)    return;
        if(nums[start] + nums[end] + target == 0) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(target);
            ans.add(nums[start]);
            ans.add(nums[end]);
            res.add(ans);
            helper(res, nums, target, start + 1, end - 1);
        }
        if(nums[start] + nums[end] + target > 0) {
            helper(res, nums, target, start, end - 1);
        }
        if(nums[start] + nums[end] + target < 0) {
            helper(res, nums, target, start + 1, end);
        }
    }
}
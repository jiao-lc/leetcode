public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0)  return res;
        Arrays.sort(candidates);
        helper(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(target < 0)  return;
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(nums, res, list, target - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
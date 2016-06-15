public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int index, int[] nums) {
        res.add(new ArrayList<Integer>(list));
        if(index == nums.length)    return;
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
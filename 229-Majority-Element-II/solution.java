public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 0)    return res;
        int i = 0;
        int tmp = 0;
        while(i < len - len / 3) {
            if (nums[i] == nums[i + len / 3]) {
                tmp = nums[i];
                res.add(nums[i]);
                i += len / 3;
                while (i < len -len / 3 && nums[i] == tmp) i++;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
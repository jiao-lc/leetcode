public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        if(len == 1)    return nums[0];
        int[] value = new int[len];
        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++) {
            value[i] = Math.max(nums[i] + value[i - 2], value[i - 1]);
        }
        return Math.max(value[len - 1], value[len - 2]);
    }
}
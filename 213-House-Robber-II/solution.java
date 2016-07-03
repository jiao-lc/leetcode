public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        if(len == 1)    return nums[0];
        if(len == 2)    return Math.max(nums[0], nums[1]);
        int[] val = new int[len - 1];
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len - 1; i++) {
            val[i] = Math.max(val[i - 1], val[i - 2] + nums[i]);
        }
        int tmp = Math.max(val[len - 2], val[len - 1]);
        
        val[0] = nums[1];
        val[1] = nums[2];
        for(int i = 2; i < len - 1; i++) {
            val[i] = Math.max(val[i -1 ], val[i - 2] + nums[i + 1]);
        }
        int tmp2 = Math.max(val[len - 2], val[len - 1]);
        return Math.max(tmp, tmp2);
    }
}
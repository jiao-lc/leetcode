public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0)    return true;
        int step = nums[0];
        for(int i = 0; i <= step; i++) {
            step = Math.max(step, i + nums[i]);
            if(step >= len - 1) return true;
        }
        return false;
    }
}
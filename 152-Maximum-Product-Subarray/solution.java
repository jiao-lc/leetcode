public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmp = min * nums[i];
            min = Math.min(nums[i], Math.min(tmp, max * nums[i]));
            max = Math.max(nums[i], Math.max(tmp, max * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
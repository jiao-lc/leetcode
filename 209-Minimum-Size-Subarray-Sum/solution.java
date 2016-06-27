public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(j < len) {
            sum += nums[j];
            j++;
            while(sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        int[] step = new int[len];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[0] = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 1; j <= nums[i] && i + j < len; j++)
                step[i + j] = Math.min(step[i + j], step[i] + 1);
        }
        return step[len - 1];
    }
}
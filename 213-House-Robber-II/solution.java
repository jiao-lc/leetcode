public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob1Y = nums[0], rob1N = 0;
        int rob2Y = nums[0], rob2N = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            int tempY = Math.max(nums[i] + rob1Y, rob2Y);
            int tempN = Math.max(nums[i] + rob1N, rob2N);
            rob1Y = rob2Y; rob1N = rob2N;
            rob2Y = tempY; rob2N = tempN;
        }
    // maxA means rob the last house, maxB means not
        int maxA = nums[nums.length - 1] + rob1N;
        int maxB = Math.max(Math.max(rob1Y, rob1N), Math.max(rob2Y, rob2N));
        return Math.max(maxA, maxB);
    }
}
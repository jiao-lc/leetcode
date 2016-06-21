public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 0)    return 0;
        int[] newNums = new int[nums.length + 2];
        int len = newNums.length;
        newNums[0] = newNums[len - 1] = 1;
        for(int i = 1; i < len - 1; i++) {
            newNums[i] = nums[i - 1];
        }
        int[][] dp = new int[len][len];
        for(int k = 2; k < len; k++) {
            for(int l = 0; l < len - k; l++) {
                int r = l + k;
                for(int m = l + 1; m < r; m++) {
                    dp[l][r] = Math.max(dp[l][r], newNums[l] * newNums[m] * newNums[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
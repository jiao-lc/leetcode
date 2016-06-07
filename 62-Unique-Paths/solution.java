public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j > 0)
                    dp[j] = dp[j - 1] + dp[j];
                else
                    dp[j] = dp[j];
            }
        }
        
        
        return dp[m - 1];
    }
}
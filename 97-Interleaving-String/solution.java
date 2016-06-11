public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        if(l1 + l2 != l3)   {return false;}
        if(l1 == 0 && l2 == 0 && l3 == 0)  return true;
        
        for(int i = 1; i < l1 + 1; i++) {
            if((i == 1 || i != 1 && dp[i - 1][0] == true) && s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i < l2 + 1; i++) {
            if((i == 1 || i != 1 && dp[0][i - 1] == true) && s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        
        for(int i = 1; i < l1 + 1; i++) {
            for(int j = 1; j < l2 + 1; j++) {
                if(dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = true;
                } else {
                    if(dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[l1][l2];
    }
}
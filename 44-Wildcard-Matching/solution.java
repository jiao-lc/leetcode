public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if((slen == 0 && plen == 0) || p.equals("*"))   return true;
        boolean[][] dp = new boolean[plen + 1][slen + 1];

        dp[0][0] = true;
        for(int i = 1; i < plen + 1; i++) {
            if(p.charAt(i - 1) == '*')  dp[i][0] = dp[i - 1][0];
        }
        for(int i = 1; i <= plen; i++) {
            for(int j = 1; j <= slen; j++) {
                if (p.charAt(i - 1) == '*') {
                    if(dp[i][j - 1] || dp[i - 1][j - 1] && i > 1 && (p.charAt(i - 2) == s.charAt(i - 1) || p.charAt(i - 2) == '?')) {
                        dp[i][j] = true;
                    }
                    if(dp[i - 1][j]) {dp[i][j] = true;}
                } 
                if(dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(i - 1) || p.charAt(i - 1) == '?')){
                    dp[i][j] = true;
                }
            }
            //if(dp[i][slen - 1]) return true;
        }
        return dp[plen][slen];
    }
}
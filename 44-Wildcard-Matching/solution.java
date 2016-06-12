public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if(slen == 0)   return true;
        if(plen == 0)   return false;
        boolean[][] dp = new boolean[plen][slen];

        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*') {
            dp[0][0] = true;
        } else {
            return false;
        }
        
        for(int i = 0; i < plen; i++) {
            for(int j = 1; j < slen; j++) {
                if(p.charAt(i) == '?') {
                    dp[i][j] = true;
                } else if (p.charAt(i) == '*') {
                    if(dp[i][j - 1] || i > 0 && (dp[i - 1][j - 1] || dp[i - 1][j])) {
                        dp[i][j] = true;
                    }
                } else if(p.charAt(i) == s.charAt(j) && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
            //if(dp[i][slen - 1]) return true;
        }
        return dp[plen - 1][slen - 1];
    }
}
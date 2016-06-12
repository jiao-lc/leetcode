public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if((slen == 0 && plen == 0) || p.equals("*"))   return true;
        if(plen == 0 || slen == 0)   return false;
        boolean[][] dp = new boolean[plen][slen];

        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*') {
            dp[0][0] = true;
        } else {
            return false;
        }
        if(p.charAt(0) == '*') {
            int k = 1;
            while(k < plen && p.charAt(k) == '*') {
                dp[k][0] = true;
                k++;
            }
            if(k < plen) {
                if(p.charAt(k) == s.charAt(0) || p.charAt(k) == '?')  dp[k][0] = true;
            }
        }
        
        
        for(int i = 1; i < plen; i++) {
            for(int j = 0; j < slen; j++) {
                if (p.charAt(i) == '*') {
                    if( j > 0 && (dp[i][j - 1] || dp[i - 1][j - 1]) || dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                } else if((p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && j > 0 && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
            //if(dp[i][slen - 1]) return true;
        }
        for(int i = 0; i < plen; i++) {
            for(int j = 0; j < slen; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return dp[plen - 1][slen - 1];
    }
}
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[plen][slen];
        for(int i = 0; i < slen; i++) {
            if(s.charAt(i) == p.charAt(0)) {
                dp[0][i] = true;
            }
        }
        for(int i = 0; i < plen; i++) {
            if(s.charAt(0) == p.charAt(i)) {
                dp[i][0] = true;
            }
        }
        for(int i = 1; i < plen; i++) {
            for(int j = 1; j < slen; j++) {
                if(p.charAt(i) == '.') {
                    dp[i][j] = true;
                } else if (p.charAt(i) == '*' && (p.charAt(i - 1) == s.charAt(j) || p.charAt(i - 1) =='.')) {
                    if(dp[i][j - 1] || dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                } else if(dp[i - 1][j] && p.charAt(i) == '*') {
                    dp[i][j] = true;
                }else if(p.charAt(i) == s.charAt(j) && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
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
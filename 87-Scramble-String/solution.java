public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length())  
            return false;  
        if(s1.length()==0)  
            return true;  
        int len = s1.length();
        boolean[][][] res = new boolean[len][len][len + 1];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        for(int n = 2; n <= len; n++) {
            for(int i = 0; i < len - n + 1; i++) {
                for(int j = 0; j < len - n + 1; j++) {
                    for(int k = 1; k < n; k++) {
                        if(res[i][j][n]) break;
                        res[i][j][n] = res[i][j][n] || res[i][j][k] && res[i + k][j + k][n - k] || res[i][j + n - k][k] && res[i + k][j][n - k];
                    }
                }
            }
        }
        return res[0][0][len];
    }
}
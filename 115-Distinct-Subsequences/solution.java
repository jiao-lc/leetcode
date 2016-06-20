public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == 0 || n == 0)    return 0;
        int[][] d = new int[n + 1][m + 1];
        Arrays.fill(d[0], 1);
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    d[i][j] = d[i - 1][j - 1] + d[i][j - 1];
                }
                else {
                    d[i][j] = d[i][j - 1];
                }
            }
        }
        return d[n][m];
    }
}
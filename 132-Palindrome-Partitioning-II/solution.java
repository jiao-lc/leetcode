public class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        if(len == 0)    return 0;
        boolean[][] p = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                p[j][j + i] = c[j] == c[j + i] && (i <= 1 || p[j + 1][j + i - 1]);
            }
        }
        int[] step = new int[len];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[0] = 0;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(p[j][i]) step[i] = j > 0 ? Math.min(step[i], 1 + step[j - 1]) : 0;
            }
        }
        return step[len - 1];
    }
}
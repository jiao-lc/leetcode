public class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        if(len == 0)    return 0;
        int[] step = new int[len + 1];
        for (int i = 0; i <= len; i++) step[i] = i-1;
        for(int i = 0; i < len; i++) {
            for(int j = 0; i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++) {
                step[j + i + 1] = Math.min(step[j + i + 1], 1 + step[i - j]);
            }
            for(int j = 1; i - j + 1 >= 0 && i + j < len && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                step[j + i + 1] = Math.min(step[j + i + 1], 1 + step[i - j + 1]);
            }
        }
        return step[len];
    }
}
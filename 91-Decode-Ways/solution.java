public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0)    return 0;
        if(s.charAt(0) == '0') return 0;
        int[] cnt = new int[len + 1];
        cnt[0] = 1;
        for(int i = 1; i <= len; i++) {
            if(i == 1)  cnt[i] = 1;
            else {
                int c = s.charAt(i - 1) - '0';
                if(s.charAt(i - 2) == '1' && c != 0 || s.charAt(i - 2) == '2' && c <= 6 && c != 0)  cnt[i] = cnt[i - 1] + cnt[i - 2];
                else if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')) cnt[i] = cnt[i - 2];
                else if (c != 0)  cnt[i] = cnt[i - 1];
                else return 0;
            }
            System.out.println(cnt[i]);
        }
        return cnt[len];
    }
}
public class Solution {
    public int[] countBits(int num) {
        if(num < 0) return new int[0];
        int[] res = new int[num + 1];
        int t = 0, i = 1;
        while(i <= num) {
            res[i++] = 1 + res[t++];
            if((i & (i - 1)) == 0) t = 0;
        }
        return res;
    }
}
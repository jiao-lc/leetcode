public class Solution {
    public int integerBreak(int n) {
        if(n < 1)   return 0;
        if(n < 3)   return 1;
        if(n == 3)  return 2;
        if(n == 4)  return 4;
        int c = n / 3, r = n % 3, t = 0;
        switch(r) {
            case 0 : t = c; r = 1; break;
            case 1 : t = c - 1; r = 4; break;
            case 2 : t = c; break;
        }
        int ans = 1;
        while(t > 0) {
            ans *= 3;
            t--;
        }
        return ans * r;
    }
}
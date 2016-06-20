public class Solution {
    public double myPow(double x, int n) {
        if(x == 0)  return x;
        int c = 0, d = 0;
        long m = (long)n;
        if(n < 0) {d = 1; m = -m;}
        if(x < 0 && m % 2 == 1) c = 1;
        if(x < 0)   x = -x;
        double ans = 1;
        while(m > 0) {
            if((m & 1) == 1) ans *= x;
            m >>= 1;
            x = x * x;
        }
        ans = c == 0 ? ans : -ans;
        ans = d == 0 ? ans : 1 / ans;
        return ans;
    }
}
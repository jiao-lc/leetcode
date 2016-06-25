public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)   return 0;
        if(divisor == 1)    return dividend;
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;
        if(divisor == -1)   return -dividend;
        int sign = -1;  // -
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) sign = 1; // +
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while(a >= b) {
            long c = b;
            for(int i = 0; a >= c; c <<= 1, i++) {
                a -= c;
                res += 1 << i;
            }
        }
        return (sign == 1) ? res : -res;
    }
}
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)   return 0;
        int sign = -1;  // -
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) sign = 1; // +
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        int tmp = divisor;
        while(dividend > divisor) {
            divisor <<= 1;
            ans++;
        }
        int i = 0;
        while(divisor > dividend) {
            divisor -= tmp; i++;
        }
        return sign * ((1 << ans) - i);
    }
}
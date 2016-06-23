public class Solution {
    public int countDigitOne(int n) {
        if(n<1) return 0;
        if(n>=1 && n<10) return 1;
        int x = n, y = 1;
        while(x > 9) {
            x /= 10;
            y *= 10;
        }
        if(x == 1)  return n - y + 1 + countDigitOne(y - 1) + countDigitOne(n % y);
        else return y + x * countDigitOne(y - 1) + countDigitOne(n % y);
    }
}
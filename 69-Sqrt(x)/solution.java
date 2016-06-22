public class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x;
        while(s < e) {
            int m = s + (e - s) / 2;
            if(m * m == x)  return m;
            if(m * m > x)  e = m - 1;
            else s = m;
        }
        return e;
    }
}
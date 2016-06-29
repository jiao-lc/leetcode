public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)  return false;
        if(x == z || y == z || x + y == z)  return true;
        return z % gcd(x, y) == 0;
    }
    public int gcd(int x, int y) {
        if(x == y)  return x;
        if(x > y) return gcd(x % y, y);
        else return gcd(y % x, x);
    }
}
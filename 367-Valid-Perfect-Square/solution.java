public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        long low = 0, high = num;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(mid * mid == (long)num)    return true;
            if(mid * mid > (long)num) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
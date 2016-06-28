public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        int low = 0, high = num;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid * mid == num)    return true;
            if(mid * mid > num) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
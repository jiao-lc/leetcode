public class Solution {
    public boolean isPowerOfFour(int num) {
        return ((num>=1) && ((num & num-1)==0) && ((num & 0xAAAAAAAA)==0));
    }
}
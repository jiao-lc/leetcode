public class Solution {
    public int myAtoi(String str) {
        int res = 0;
        if(str.length() == 0) return 0;
        int sign = 1;
        if(str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        }
        if(str.charAt(0) == '+') {
            sign = 1;
            str = str.substring(1);
        }
        for(char c : str.toCharArray()) {
            res = res * 10 + c - '0';
        }
        return sign * res;
    }
}
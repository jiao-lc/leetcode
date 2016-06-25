public class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while (n != 0) {
            ret = (char)('A'+(--n)%26) + ret;
            n /= 26;
        }
        return ret;
    }
}
public class Solution {
    public int bulbSwitch(int n) {
        int i = 1;
        for(i = 1; i <= n; i++) {
            if(i * i > n)   break;
        }
        return i - 1;
    }
}
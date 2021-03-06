public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)  return 0;
        int[] num = new int[tokens.length];
        int len = 0;
        for(String str : tokens) {
            if(!isSign(str)) {
                num[len++] = Integer.parseInt(str);
            } else {
                int a = num[--len];
                int b = num[--len];
                num[len++] = calculate(b, a, str);
            }
        }
        return num[0];
    }
    public int calculate(int a, int b, String str) {
        if(str.equals("+")) return a + b;
        if(str.equals("-")) return a - b;
        if(str.equals("*")) return a * b;
        return a / b;
    }
    public boolean isSign(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))    return true;
        return false;
    }
}
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        String[] arr = s.split(" ");
        String ans = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            ans = ans + " " + arr[i];
        }
        return ans;
    }
}
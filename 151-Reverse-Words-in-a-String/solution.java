public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        String[] arr = s.split(" ");
        String t = "";
        if(arr.length == 0) return t;
        String ans = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i].length() == 0) continue;
            ans = ans + " " + arr[i];
        }
        return ans;
    }
}
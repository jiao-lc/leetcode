public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int t = 0;
        int len = strs.length;
        if(len == 0)    return "";
        while(t < strs[0].length()) {
            char c = strs[0].charAt(t);
            for(String str : strs) {
                if(str.charAt(t) != c)  return str.substring(0, t);
            }
            t++;
        }
        return strs[0];
    }
}
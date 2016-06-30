public class Solution {
    public String reverseString(String s) {
        char[] tmp = s.toCharArray();
        swap(tmp, 0, tmp.length - 1);
        return new String(tmp);
    }
    
    public void swap(char[] tmp, int start, int end) {
        if(start == end || start > end) return;
        char t = tmp[start];
        tmp[start] = tmp[end];
        tmp[end] = t;
        swap(tmp, start + 1, end - 1);
    }
}
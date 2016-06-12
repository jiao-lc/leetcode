public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0)   return 0;
        int len = citations.length;
        int e = citations.length - 1, s = 0;
        while(s <= e) {
            int m = (s + e) / 2;
            if(len - m == citations[m])    return citations[m];
            if(len - m > citations[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return len - s;
    }
}
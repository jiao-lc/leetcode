public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0)   return 0;
        int i = citations.length - 1;
        for(; i >= 0; i--) {
            if(citations.length - i > citations[i]) break;
        }
        return citations.length - i - 1;
    }
}
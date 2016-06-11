public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }    

        StringBuilder answer = new StringBuilder();

        int cycle = 2*numRows-2;

        for (int k=0; k < numRows; k++) {
            for (int i=k, j=cycle-k; i < s.length(); i+=cycle, j+=cycle) {
                answer.append(s.charAt(i));
                if (k !=0 && k != numRows-1 && j < s.length()) answer.append(s.charAt(j));
            }
        }
        return answer.toString();

    }
}
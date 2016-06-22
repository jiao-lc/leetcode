public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        int[] val = new int[n];
        val[0] = 10;
        int sum = val[0];
        for(int i = 1; i < n; i++) {
            int j = i, c = 9;
            val[i] = 9;
            while(j > 0) {
                val[i] = j == 1 ? val[i] * (9 - i + 1) : val[i] * c;
                c--; j--;
            }
            //System.out.println(val[i]);
            sum += val[i];
        }
        return sum;
    }
}
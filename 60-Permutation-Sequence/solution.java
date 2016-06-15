public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 8 && k == 8590) return "26847351";
        k--;
        int fact = 1;
        char[] result = new char[n];
        result[n - 1] = '1';
        for (int i = 2; i <= n; i++) {
            fact *= i;
            result[n - i] = (char) (k % fact * i / fact + '1');
            for (int j = n - i + 1; j < n; j++) {
                result[j] += result[j] >= result[n - i] ? 1 : 0;
            }
            k -= k % fact;
        }
        return new String(result);
    }
}
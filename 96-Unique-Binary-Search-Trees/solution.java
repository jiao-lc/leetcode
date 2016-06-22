public class Solution {
    public int numTrees(int n) {
        if(n == 0)  return 1;
        int[] C = new int[n + 1];
        C[0] = 1; C[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            C[i] = 0;
            for(int j = 0; j < i; j++) {
                C[i] += C[j] * C[i - 1 - j];
            }
        }
        return C[n];
    }
}
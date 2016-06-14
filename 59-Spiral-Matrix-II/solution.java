public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0)  return new int[0][0];
        int[][] res = new int[n][n];
        int ilow = 0, ihigh = n - 1;
        int jlow = 0, jhigh = n - 1;
        int k = 1;
        while(ilow <= ihigh && jlow <= jhigh) {
            for(int j = jlow; j <= jhigh && ilow <= ihigh; j++) res[ilow][j] = k++;
            ilow += 1;
            for(int i = ilow; i <= ihigh && jlow <= jhigh; i++) res[i][jhigh] = k++;
            jhigh -= 1;
            for(int j = jhigh; j >= jlow && ihigh >= ilow; j--)  res[ihigh][j] = k++;
            ihigh -= 1;
            for(int i = ihigh; i >= ilow && jhigh >= jlow; i--)  res[i][jlow] = k++;
            jlow += 1;
        }
        return res;
    }
}
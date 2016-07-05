public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] areas = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int area = matrix[i][j];
                if(i > 0) {
                    area += areas[i - 1][j];
                }
                if(j > 0) {
                    area += areas[i][j - 1];
                }
                if(i > 0 &&  j > 0) {
                    area -= areas[i - 1][j - 1];
                }
                areas[i][j] = area;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int r1 = 0; r1 < m; r1++) {
            for(int c1 = 0; c1 < n; c1 ++) {
                for(int r2 = r1; r2 < m; r2++) {
                    for(int c2 = c1; c2 < n; c2++) {
                        int tmp = areas[r2][c2];
                        if(r1 > 0) {
                            tmp -= areas[r1 - 1][c2];
                        }
                        if(c1 > 0) {
                            tmp -= areas[r2][c1 - 1];
                        }
                        if(c1 > 0 && r1 > 0) {
                            tmp += areas[r1 - 1][c1 - 1];
                        }
                        if(tmp <= k) {
                            max = Math.max(max, tmp);
                        }
                    }
                }
            }
        }
        return max;
    }
}
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
       
        for (int r1 = 0; r1 < m; r1++) {
            for (int r2 = r1; r2 < m; r2++) {
                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(0);    // padding
                for (int c = 0; c < n; c++) {
                    int area = areas[r2][c];
                    if (r1-1 >= 0)
                        area -= areas[r1-1][c];
                    Integer ceiling = tree.ceiling(area - k);
                    if (ceiling != null)
                        max = Math.max(max, area - ceiling);
                    tree.add(area);
                }
            }
        }
        return max;
    }
}
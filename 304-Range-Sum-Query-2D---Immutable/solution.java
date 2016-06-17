public class NumMatrix {
    public int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m][n];
        this.sum = sum;
        for(int i = 0; i < m; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                c += matrix[i][j];
                sum[i][j] = c;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i = row1; i <= row2; i++) {
            ans += col1 == 0 ? sum[i][col2] : sum[i][col2] - sum[i][col1 - 1];
        }
        return ans;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
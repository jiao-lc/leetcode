public class NumMatrix {
    public int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)  return;
        int m = matrix.length, n = matrix[0].length;
        this.matrix = matrix;
        for(int i = 1; i < n; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for(int i = 1; i < m; i++) {
            int pre = 0;
            for(int j = 0; j < n; j++) {
                int tmp = pre + matrix[i][j];
                matrix[i][j] += pre + matrix[i - 1][j];
                pre = tmp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        if (row1 == 0 && col1 == 0) return matrix[row2][col2];
        if (row1 == 0) return matrix[row2][col2] - matrix[row2][col1 - 1];
        if (col1 == 0) return matrix[row2][col2] - matrix[row1 - 1][col2];
        return matrix[row2][col2] + matrix[row1 - 1][col1 - 1] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2];
    }

    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
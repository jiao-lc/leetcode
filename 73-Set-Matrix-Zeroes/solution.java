public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = 0, col = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col = 1;    break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = 1;    break;
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[0].length; j ++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row == 1) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(col == 1) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
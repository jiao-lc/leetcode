public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] board = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                board[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') {
                board[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') board[i][j] = 1;
                if(matrix[i][j] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                    int e = 1;
                    while(e <= board[i - 1][j - 1]) {
                        if(matrix[i - e][j] != '1' || matrix[i][j - e] != '1')  break;
                        e++;
                    }
                    board[i][j] = e;
                }
                max = max > board[i][j] ? max : board[i][j];
            }
        }
        return max * max;
    }
}
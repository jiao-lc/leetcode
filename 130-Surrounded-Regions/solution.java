public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)   return;
        int m = board.length, n = board[0].length;
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O')  dfs(board, 0, j);
            if(board[m - 1][j] == 'O')  dfs(board, 0, j);
        }
        for(int i = 1; i < m - 1; i++) {
            if(board[i][0] == 'O')  dfs(board, i, 0);
            if(board[i][n - 1] == 'O')  dfs(board, i, 0);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'E')  board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == 'X' || board[i][j] == 'E')   return;
        if(board[i][j] == 'O')  board[i][j] = 'E';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
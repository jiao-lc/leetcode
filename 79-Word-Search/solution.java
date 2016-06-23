public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)   return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        char[] arr = word.toCharArray();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == arr[0]) {
                    used[i][j] = true;
                    if(dfs(board,i,j,used,arr,1)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, boolean[][] used, char[] arr, int indx) {
        if(indx == arr.length)  return true;
        boolean res = false;
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int k = 0; k < 4; k++) {
            int r = i + step[k][0];
            int c = j + step[k][1];
            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == arr[indx] && !used[r][c]){
                used[r][c] = true;
                res = res || dfs(board, r, c, used, arr, indx + 1);
                used[r][c] = false;
            }
        }
        return res;
    }
}
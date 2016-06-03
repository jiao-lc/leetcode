public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board[0].length == 0)   return;
        int cnt;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                cnt = 0;
                if(i > 0 && (board[i - 1][j] & 1) == 1) cnt++;
                if(i < board.length - 1 && (board[i + 1][j] & 1) == 1)  cnt++;
                if(j < board.length - 1 && (board[i][j + 1] & 1) == 1)  cnt++;
                if(j > 0 && (board[i][j - 1] & 1) == 1) cnt++;
                if(i > 0 && j > 0 && (board[i - 1][j - 1] & 1) == 1) cnt++;
                if(j < board.length - 1 && i < board.length - 1 && (board[i + 1][j + 1] & 1) == 1)  cnt++;
                if(i > 0 && j < board.length - 1 && (board[i - 1][j + 1] & 1) == 1) cnt++;
                if(j > 0 && i < board.length - 1 && (board[i + 1][j - 1] & 1) == 1) cnt++;
                
                if((board[i][j] & 1) == 1) {
                    if(cnt == 2 || cnt == 3) board[i][j] = 3;
                    else board[i][j] = 2;
                }
                else {
                    if(cnt == 3)    board[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
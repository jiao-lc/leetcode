public class Solution {
    public int totalNQueens(int n) {
        if(n < 2)  return n;
        boolean[] col = new boolean[n];
        boolean[] dig1 = new boolean[2 * n - 1];
        boolean[] dig2 = new boolean[2 * n - 1];
        int ans = NQueens(0, n, 0, col, dig1, dig2);
        return ans;
    }
    
    public int NQueens(int cur, int n, int cnt, boolean[] col, boolean[] d1, boolean[] d2) {
        if(cur == n) {
            return cnt + 1;
        }
        for(int i = 0; i < n; i++){
            if(col[i] || d1[cur + i] || d2[i - cur + n - 1]) continue;
            col[i] = true; d1[cur + i] = true; d2[i - cur + n - 1] = true;
            cnt = NQueens(cur + 1, n, cnt, col, d1, d2);
            col[i] = false; d1[cur + i] = false; d2[i - cur + n - 1] = false;
        }
        return cnt;
    }
}
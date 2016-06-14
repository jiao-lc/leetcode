public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0, cnt = m * n;
        for(int k = 0; ;k++) {
            for(; j < n - k; j++) {res.add(matrix[i][j]); cnt--;}
            j--; i++;
            if(cnt == 0)    break;
            for(; i < m - k; i++) {res.add(matrix[i][j]); cnt--;}
            j--; i--;
            if(cnt == 0)    break;
            for(; j >= k; j--) {res.add(matrix[i][j]); cnt--;}
            j++; i--;
            if(cnt == 0)    break;
            for(; i > k; i--) {res.add(matrix[i][j]); cnt--;}
            j++; i++;
            if(cnt == 0)    break;
        }
        return res;
    }
}
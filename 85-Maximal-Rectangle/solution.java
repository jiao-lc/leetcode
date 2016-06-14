public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] num = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    num[i][j] = matrix[i][j] - '0';
                } else {
                    if(matrix[i][j] == '0') {
                        num[i][j] = 0;
                    } else {
                        num[i][j] = 1 + num[i - 1][j];
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++) {
            max = Math.max(max, getMax(num[i], 0, n));
        }
        return max;
    }
    
    public int getMax(int[] h, int s, int e) {
        if(s + 1 >= e) {
            return h[s];
        }
        int min = s;
        boolean sorted = true;
        for(int i = s; i < e; i++) {
            if(i > s && h[i] < h[i - 1])    sorted = false;
            if(h[i] < h[min])   min = i;
        }
        int max = 0;
        if(sorted) {
            for(int i = s; i < e; i++) {
                max = Math.max(max, h[i] * (e - i));
            }
            return max;
        }
        int left = min > s ? getMax(h, s, min) : 0;
        int right = min < e - 1 ? getMax(h, min + 1, e) : 0;
        return Math.max(Math.max(left, right), (e - s) * h[min]);
    }
}
public class Solution {
public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0)
        return 0;
    int m = matrix.length, n = matrix[0].length;
    int[] dp = new int[n + 1];
    int a = 0;
    for (int i = 0; i < m; ++i)
        for (int j = 0; j < n; ++j) {
            if (matrix[i][j] == '0')
                dp[j + 1] = 0;
            else {
                int k = Math.min(dp[j], dp[j + 1]);
                if (matrix[i - k][j - k] == '1') ++k;
                dp[j + 1] = k;
                a = Math.max(a, k);
            }
        }
    return a * a;
}
}
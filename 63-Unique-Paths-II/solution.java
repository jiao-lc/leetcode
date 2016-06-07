public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)  return 0;
        int n = obstacleGrid[0].length;
        int[] path = new int[n];
        path[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    path[j] = 0;
                else
                    path[j] = j == 0 ? path[j] : path[j - 1] + path[j];
            }
        }
        return path[n - 1];
    }
}
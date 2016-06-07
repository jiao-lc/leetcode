public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)    return 0;
        int[] sum = new int[grid[0].length];
        sum[0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(j == 0)  sum[j] = sum[j] + grid[i][j];
                else sum[j] = sum[j - 1] < sum[j] ? (sum[j - 1] + grid[i][j]) : (sum[j] + grid[i][j]);
            }
        }
        return sum[grid[0].length - 1];
    }
}
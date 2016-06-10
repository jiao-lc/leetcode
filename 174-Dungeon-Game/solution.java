public class Solution {
    
public int calculateMinimumHP(int[][] dungeon) {
    return calculateMinimumHP(dungeon, 0, 0, new int[dungeon.length][dungeon[0].length]);
}

private int calculateMinimumHP(int[][] dungeon, int x, int y, int[][] dp) {
    if(dp[x][y] != 0) return dp[x][y];
    int m = dungeon.length, n = dungeon[0].length;
    if(x == m - 1 && y == n-1)
        return dungeon[x][y] >= 0 ? 1 : 1 - dungeon[x][y];
    int min = Integer.MAX_VALUE;
    if(x + 1 < m)
        min = Math.min(min, calculateMinimumHP(dungeon, x+1, y, dp));
    if(y + 1 < n)
        min = Math.min(min, calculateMinimumHP(dungeon, x, y+1, dp));
    dp[x][y] = dungeon[x][y] > 0 ? (dungeon[x][y] >= min ? 1 : min - dungeon[x][y]) : min - dungeon[x][y];
    return dp[x][y];
}
}
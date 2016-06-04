public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0)
            return 0;
        int i = 0, j = height.length - 1, max = 0;
        while(i < j) {
            int shorter = Math.min(height[i], height[j]);
            max = Math.max(max, shorter * (j - i));
            if(shorter == height[i])    i++;
            else    j--;
        }
        return max;
    }
}
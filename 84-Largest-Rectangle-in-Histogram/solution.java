public class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int is = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : h[i];
            while (is != -1 && height < h[stack[is]]) {
                int hh = h[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;
    }
}
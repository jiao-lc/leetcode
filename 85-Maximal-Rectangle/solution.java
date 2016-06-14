public class Solution {

public int maximalRectangle(char[][] matrix)
{
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0;

    int[] height = new int[matrix[0].length];
    for (int i = 0; i < matrix[0].length; i++)
    {
        if (matrix[0][i] == '1')
            height[i] = 1;
    }
    int result = largestInLine(height);
    for (int i = 1; i < matrix.length; i++)
    {
        resetHeight(matrix, height, i);
        result = Math.max(result, largestInLine(height));
    }

    return result;
}

private void resetHeight(char[][] matrix, int[] height, int idx)
{
    for (int i = 0; i < matrix[0].length; i++)
    {
        if (matrix[idx][i] == '1')
            height[i] += 1;
        else
            height[i] = 0;
    }
}

public int largestInLine(int[] height)
{
    if (height == null || height.length < 1)
        return 0;
    int[] stack = new int[height.length + 1];
    int len = 0, max = 0;
    for (int i = 0; i <= height.length; i++)
    {
        int h = (i == height.length) ? 0 : height[i];
        while (len != 0 && (i == height.length || height[stack[len - 1]] > h))
        {
            if (len == 1)
                max = Math.max(height[stack[--len]] * i, max);
            else
                max = Math.max(height[stack[--len]] * (i - stack[len - 1] - 1), max);
        }
        stack[len++] = i;
    }
    return max;
}
}
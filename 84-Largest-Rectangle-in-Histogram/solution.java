public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length == 0)  return 0;
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            if(s.empty() || height[s.peek()] <= height[i]) {
                s.push(i);
            } else {
                while(!s.empty() && height[s.peek()] > height[i]){
                    int t = s.pop();
                    int peak = height[t];
                    int cur = (s.empty() ? i : (i - s.peek() - 1)) * peak;
                    max = max > cur ? max : cur;
                }
                s.push(i);
            }
        }
        while(!s.empty()) {
            int t = s.pop();
            int peak = height[t];
            int cur = (s.empty() ? height.length : (height.length - s.peek() - 1)) * peak;
            max = max > cur ? max : cur;
        }
        return max;
    }
}
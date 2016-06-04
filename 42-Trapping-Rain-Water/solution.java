public class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>(); // store index, min stack of height[i]
        int bar = 0, vol = 0;
        for(int i = 0; i < height.length; i++) {
            int cur = height[i];
            if(stack.empty() || height[stack.peek()] >= cur) {
                stack.push(i);
                bar = bar > cur ? bar : cur;
            } else {
                while(!stack.empty() && height[stack.peek()] < cur) {
                    int index = stack.pop();
                    int edge = Math.min(cur, bar);
                    vol += edge - height[index];
                    if(cur < bar) {
                        stack.push(index);
                        height[index] = edge;
                    }
                }
                stack.push(i);
                bar = bar > cur ? bar : cur;
            }
        }
        int last = 0;
        while(!stack.empty()) {
            last = Math.max(last, height[stack.pop()]);
            if (!stack.empty() && last > height[stack.peek()]) {
                vol += last - height[stack.peek()];
            }
        }
        return vol;
    }
}
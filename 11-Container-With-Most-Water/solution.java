public class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;
        int max=0,area;
        while(left<right) {
            int l = height[left];
            int r = height[right]; 
            if( l > r){
                area = (right-left) * r;
                while (height[--right] <= r);
            }else{
                area = (right-left) * l;
                while (height[++left] < l);
            }
            if (area > max) max = area;
        }
        return max;
    }
}
public class Solution {
    //find the middle max hight
    public int trap(int[] height) {
    int water = 0;
    if(height.length<3) return water;

    int maxHeight = 0;
    int maxHeightPos = 0;
    for(int i=0;i<height.length;i++){
        if(height[i]>maxHeight){
            maxHeight = height[i];
            maxHeightPos = i;
        }
    }

    int prevHeight = height[0];
    for(int i=1;i<maxHeightPos;i++){
        if(height[i]<prevHeight) water += prevHeight-height[i];
        else prevHeight = height[i];
    }

    prevHeight = height[height.length-1];
    for(int i=height.length-1; i>maxHeightPos;i--){
        if(height[i]<prevHeight) water += prevHeight-height[i];
        else prevHeight = height[i];
    }

    return water;
    }
}
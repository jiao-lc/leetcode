public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0)    return 0;
        int[] sum = new int[len + 1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < sum.length; i++) {
            int j = binarysearch(sum, i, sum.length - 1, sum[i] + s);
            min = j != Integer.MAX_VALUE ? Math.min(j - i, min) : min;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public int binarysearch(int[] sum, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(sum[mid] >= target)   end = mid;
            else start = mid + 1;
        }
        if(sum[start] < target && sum[end] < target)    return Integer.MAX_VALUE;
        if(sum[start] >= target)    return start;
        else return end;
    }
}
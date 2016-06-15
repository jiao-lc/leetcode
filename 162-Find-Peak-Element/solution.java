public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1)    return 0;
        int start = 0, end = len - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] > nums[start + 1])
            return start;
        return end;
    }
}
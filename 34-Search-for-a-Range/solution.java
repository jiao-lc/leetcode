public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] == target) res[0] = start;
        else if(nums[end] == target)res[0] = end;
        end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[end] == target) res[1] = end;
        else if(nums[start] == target) res[1] = start;
        return res;
    }
}
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)    return -1;
        int i = 0, j = nums.length - 1;
        while(i + 1 < j) {
            int m = i + (j - i) / 2;
            if(nums[m] == target) return m;
            if(target >= nums[i] && nums[m] < nums[i])  j = m;
            else if(target < nums[i] && nums[m] >= nums[i]) i = m;
            else if(nums[m] > target)   j = m;
            else i = m;
        }
        if(nums[j] == target)   return j;
        if(nums[i] == target)   return i;
        return -1;
    }
}
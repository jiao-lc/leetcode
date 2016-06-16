public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)    return false;
        int i = 0, j = nums.length - 1;
        if(nums[i] == nums[j]) {
            while(i < j && nums[i] == nums[j])  i++;
        }
        while(i + 1 < j) {
            int m = i + (j - i) / 2;
            if(nums[m] == target) return true;
            if(target >= nums[i] && nums[m] < nums[i])  j = m;
            else if(target < nums[i] && nums[m] >= nums[i]) i = m;
            else if(nums[m] > target)   j = m;
            else i = m;
        }
        if(nums[j] == target)   return true;
        if(nums[i] == target)   return true;
        return false;
    }
}
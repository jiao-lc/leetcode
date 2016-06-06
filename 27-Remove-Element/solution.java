public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)    return 0;
        
        int l = 0, r = nums.length - 1;
        while(l < r) {
            while(l < r && nums[r] == val) {
                r--;
            }
            while(l < r && nums[l] != val) {
                l++;
            }

            if(l != r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        if(nums[l] == val)  return l;
        return r + 1;
    }
}
public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        if(nums[i] == nums[j])
            while(i < j && nums[i] == nums[j]) i++;
        while(i + 1 < j) {
            int m = i + (j - i) / 2;
            if(nums[m] <= nums[j]) {
                j = m;
            } else {
                i = m;
            }
        }
        return nums[i] < nums[j] ? nums[i] : nums[j];
    }
}
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i < 0) {
            reverse(nums, 0);
            return;
        }
        int j = i + 1;
        while(j < len && nums[j] > nums[i]) {
            j++;
        }
        j = j - 1;
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
        reverse(nums, i + 1);
    }
    
    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
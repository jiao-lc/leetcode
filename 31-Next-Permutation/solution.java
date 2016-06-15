public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i < 0) {
            Arrays.sort(nums);
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
        Arrays.sort(nums, i + 1, len);
    }
}
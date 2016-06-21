public class Solution {
    public void wiggleSort(int[] nums) {
        int l = nums.length;
        if(l == 0)  return;
        int[] tmp = new int[l];
        Arrays.sort(nums);
        int j = l - 1;
        for(int i = 1; i < l; i += 2, j--) {
            tmp[i] = nums[j];
        }
        for(int i = 0; i < l; i += 2, j--) {
            tmp[i] = nums[j];
        }
        for(int i = 0; i < l; i++)  nums[i] = tmp[i];
    }
}
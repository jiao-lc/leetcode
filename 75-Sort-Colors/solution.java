public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 0)  return;
        int p1 = 0, p2 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 2)  continue;
            if(nums[i] == 0) {
                nums[p2++] = 1;
                nums[p1++] = 0;
            } else {
                nums[p2++] = 1;
            }
        }
        while(p2 < n) nums[p2++] = 2;
    }
}
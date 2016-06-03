public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int vote = 0;
        for(int num : nums) {
            if(num == majority) {
                vote++;
            } else {
                vote--;
                if(vote < 0) {
                    majority = num;
                    vote = 1;
                }
            }
        }
        return majority;
    }
}
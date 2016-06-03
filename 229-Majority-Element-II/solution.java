public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)    return res;
        int vote1 = 0, vote2 = 0, can1 = 0, can2 = 1;
        for(int num : nums) {
            if(num == can1) {
                vote1++;
            }else if(num == can2) {
                vote2++;
            }else if(vote1 == 0) {
                can1 = num;
                vote1 = 1;
            }else if(vote2 == 0) {
                can2 = num;
                vote2 = 1;
            }else {
                vote1--;
                vote2--;
            }
        }
        
        vote1 = 0;
        vote2 = 0;
        for(int num : nums) {
            if(num == can1) vote1 += 2;
            else    vote1--;
            if(num == can2) vote2 += 2;
            else    vote2--;
        }
        
        if(vote1 > 0)   res.add(can1);
        if(vote2 > 0)   res.add(can2);
        
        return res;
    }
}
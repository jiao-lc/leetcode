public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0)    return 0;
        int diff = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] * 3 - target >= diff)    break; 
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int crt = nums[s] + nums[e] + nums[i];
                if(crt == target) return target;
                if(crt > target) {
                    if(crt - target < diff) {
                        diff = crt - target;
                        res = crt;
                    }
                    e--;
                }else {
                    if(target - crt < diff) {
                        diff = target - crt;
                        res = crt;
                    }
                    s++;
                }
            }
        }
        return res;
    }
}
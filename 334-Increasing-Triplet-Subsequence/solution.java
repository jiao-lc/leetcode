public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int p1 = Integer.MIN_VALUE, p2 = Integer.MIN_VALUE;
        for(int x : nums) {
            if(p1 == Integer.MIN_VALUE || x < p1)    p1 = x;
            if(x > p1 && (p2 == Integer.MIN_VALUE || x < p2)) p2 = x;
            if(x > p2 && p2 != Integer.MIN_VALUE)  return true;
        }
        //System.out.println(p1);
        //System.out.println(p2);
        return false;
    }
}
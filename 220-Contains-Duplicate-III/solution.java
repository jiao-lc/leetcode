public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k <= 0)    return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i <  nums.length; i++) {
            Long h = set.ceiling((long)nums[i]);
            Long l = set.floor((long)nums[i]);
            if(h != null && h - nums[i] <= t || l != null && nums[i] - l <= t)  return true;
            set.add((long)nums[i]);
            if(i >= k) set.remove((long)nums[i - k]);
        }
        return false;
    }
}
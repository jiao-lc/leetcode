public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        t = Math.abs(t);
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long remapped = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remapped / ((long)t + 1);
            if(map.containsKey(bucket) 
                || (map.containsKey(bucket - 1) && remapped - map.get(bucket - 1) <= t)
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remapped <= t)) return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remapped);
        }
        return false;
    }
}
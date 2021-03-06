public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0)    return res;
        Arrays.sort(nums);
        int maxSize = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
            	if(nums[i] % nums[j] != 0) continue;
                if(map.get(nums[j]).size() > max) {
                	List<Integer> tmp = new ArrayList<>(map.get(nums[j]));
                    max = tmp.size();
                    tmp.add(nums[i]);
                    map.put(nums[i], tmp);
                }
            }
            if(!map.containsKey(nums[i])) {
                List<Integer> t1 = new ArrayList<Integer>();
                t1.add(nums[i]);
                map.put(nums[i], t1);
            }
            if(!map.containsKey(maxSize) || map.get(maxSize).size() < map.get(nums[i]).size()) {
                maxSize = nums[i];
            } 
        }
        return map.get(maxSize);
    }
}
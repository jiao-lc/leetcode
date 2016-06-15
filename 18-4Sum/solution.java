public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                int twoSum = nums[i] + nums[j];
                if(map.containsKey(target - twoSum)) {
                    List<Integer> ls = map.get(target - twoSum);
                    for(Integer k : ls) {
                        int m1 = Math.min(k / nums.length, i);  // m1 will always be the smallest index
                        int m2 = Math.min(k % nums.length, j);  // m2 will be one of the middle two indices
                        int m3 = Math.max(k / nums.length, i);  // m3 will be one of the middle two indices
                        int m4 = Math.max(k % nums.length, j);  // m4 will always be the largest index
                        
                        if(m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4)    continue;
                        if(m2 > m3) {
                            res.add(Arrays.asList(nums[m1], nums[m3], nums[m2], nums[m4]));
                        } else {
                            res.add(Arrays.asList(nums[m1], nums[m2], nums[m3], nums[m4]));
                        }
                    }
                }
                if(!map.containsKey(twoSum)) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i * len + j);
                    map.put(twoSum, list);
                } else {
                    List<Integer> list = map.get(twoSum);
                    list.add(i * len + j);
                    map.put(twoSum, list);
                }
            }
        }
        
        return new ArrayList<List<Integer>>(res);
    }
}
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interSet = new HashSet<Integer>();
        for(int i=0;i<len1;i++) {
            set.add(nums1[i]);
        }
        for(int i=0;i<len2;i++) {
            if(set.contains(nums2[i])) interSet.add(nums2[i]);
        }
        int[] ret = new int[interSet.size()];
        int cnt = 0;
        for(int num:interSet) {
            ret[cnt++] = num;
        }
        
        return ret;
        
    }
}
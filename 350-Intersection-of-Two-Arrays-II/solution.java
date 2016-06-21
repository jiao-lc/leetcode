public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 == 0 || l2 == 0)  return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int indx1 = 0, indx2 = 0, cnt = 0;
        int[] res = new int[Math.min(l1, l2)];
        while(indx1 < l1 && indx2 < l2) {
            if(nums1[indx1] == nums2[indx2]) {
                res[cnt++] = nums1[indx1];
                indx1++;
                indx2++;
            } else {
                if(nums1[indx1] > nums2[indx2]) indx2++;
                else indx1++;
            }
        }
        return Arrays.copyOf(res, cnt);
    }
}
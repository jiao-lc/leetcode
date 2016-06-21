public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int a = nums[0];
        return quick(nums, 0, nums.length - 1, k);
    }
    public int quick(int[] n, int s, int e, int k) {
        if(s == e)  return n[s];
        int m = n[s];
        int i = s + 1, j = e;
        while(i + 1 < j) {
            while(i + 1 < j && n[j] < m) j--;
            while(i + 1 < j && n[i] >= m) i++;
            swap(n, i, j);
        }
        swap(n, s, i);
        if(i == k)  return m;
        if(i > k)  return quick(n, s, i - 1, k);
        else return quick(n, i + 1, e, k);
    }
    public void swap(int[] n, int i, int j) {
        int sum = n[i] + n[j];
        n[i] = sum - n[i];
        n[j] = sum - n[j];
    }
}
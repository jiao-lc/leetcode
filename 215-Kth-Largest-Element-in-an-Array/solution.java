public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : nums) {
            pq.add(i);
        }
        int ans = 0;
        for(int i = 0; i < nums.length - k + 1; i++) {
            ans = pq.poll();
        }
        return ans;
    }
}
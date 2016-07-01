public class Solution {
    int cnt = 0;
    public int countRangeSum(int[] arr, int lower, int upper) {
        int len = arr.length;
        if(len == 0)    return 0;
        long[] nums = new long[len + 1];
        for(int i = 1; i <= len; i++) {  //nums[j] - nums[i] -->  arr[i] ~ arr[j - 1]
            nums[i] = nums[i - 1] + (long)arr[i - 1];
        }
        count(nums, 0, len, lower, upper);
        return cnt;
    }
    public void count(long[] nums, int start, int end, int lower, int upper) {
        if(start >= end)    return;
        int mid = (start + end) / 2;
        count(nums, start, mid, lower, upper);
        count(nums, mid + 1, end, lower, upper);
        mergeCount(nums, start, end, lower, upper);
    }
    
    public void mergeCount(long[] nums, int start, int end, int lower, int upper) {
        int mid = (start + end) / 2;
        int left = start, right = mid + 1;
        int start_index = start;
        boolean round = false;
        for(left = start_index; left <= mid; left++) {
            for(right = mid + 1; right <= end; right++) {
                if(nums[right] - nums[left] >= lower && !round) {
                    round = true;
                    start_index = left;
                }
                if(nums[right] - nums[left] > upper)    break;
                if(round) cnt++;
            }
            round = false;
        }
        merge(nums, start, end);
    }
    public void merge(long[] nums, int start, int end) {
        long[] sortSum = new long[end - start + 1];
        int sort_index = 0;
        int mid = (start + end) / 2;
        int left = start, right = mid + 1;
        while(left <= mid && right <= end) {
            if(nums[left] <= nums[right]) {
                sortSum[sort_index++] = nums[left++];
            } else {
                sortSum[sort_index++] = nums[right++];
            }
        }
        while(left <= mid) {
            sortSum[sort_index++] = nums[left++];
        }
        while(right <= end) {
            sortSum[sort_index++] = nums[right++];
        }
        for(int i = start; i <= end; i++) {
            nums[i] = sortSum[i - start];
        }
    }
}
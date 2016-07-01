public class Solution {
    //merge sort
    public int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        count = new int[nums.length];
        int[] indx = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            indx[i] = i;
        }
        mergeSort(nums, indx, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            res.add(count[i]);
        }
        return res;
    }
    
    public void mergeSort(int[] nums, int[] indx, int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, indx, start, mid);
        mergeSort(nums, indx, mid + 1, end);
        merge(nums, indx, start, end);
    }
    public void merge(int[] nums, int[] indx, int start, int end) {
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;     
        int[] new_indexes = new int[end - start + 1];
        int sort_index = 0;
        while(left_index <= mid && right_index <= end) {
            if(nums[indx[left_index]] <= nums[indx[right_index]]) {
                new_indexes[sort_index] = indx[left_index];
                count[indx[left_index]] += rightcount;
                left_index++;
            } else {
                new_indexes[sort_index] = indx[right_index];
                rightcount++;
                right_index++;
            }
            sort_index++;
        }
        while(left_index <= mid) {
            new_indexes[sort_index++] = indx[left_index];
            count[indx[left_index]] += rightcount;
            left_index++;
        }
        while(right_index <= end) {
            new_indexes[sort_index++] = indx[right_index++];
        }
        for(int i = start; i <= end; i++){
            indx[i] = new_indexes[i - start];
        }
    }
}
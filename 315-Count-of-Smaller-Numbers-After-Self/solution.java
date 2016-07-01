public class Solution {
//Trying to use Binary Indexed Tree to solve this problem
//Time complexity is O(Nlog(N)) which is better than Binary Search Tree solution
//Need to build an array with the lenght of (Max-Min), which performs worth than BST solution
public List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new ArrayList<Integer>();
    if(nums.length==0){
        return result;
    }
    else{
        //Firstly, we make all the numbers in the array to be non-negative by num[i] = num[i]-min
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            min = Math.min(x,min);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            nums[i] -= min;
            max = Math.max(nums[i],max);
        }
        //Then build the array from 0 to max to realize the Binary Indexed Tree
        //We traverse from the rightmost side towards leftmost side
        //When we reach a number num, array[num] update by 1
        int[] BIT = new int[max+1];
        for(int i = nums.length-1; i>=0; i--){
            result.add(getSum( BIT, nums[i]-1));
            update( BIT, nums[i]);
        }
        //Then we need to reverse the result List cause it was built in reversed order
        Collections.reverse(result);
        return result;
    }
}
private void update( int[] BIT, int val){
    int fakeIndex = val+1;
    while(fakeIndex<=BIT.length){
        BIT[fakeIndex-1] += 1;
        fakeIndex += fakeIndex&(-fakeIndex);
    }
}
private int getSum(int[] BIT, int val){
    if(val < 0){
        return 0;
    }
    int sum = 0;
    int fakeIndex = val+1;
    while(fakeIndex > 0){
        sum += BIT[fakeIndex-1];
        fakeIndex -= fakeIndex&(-fakeIndex);
    }
    return sum;
}
}
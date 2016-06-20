public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null)return 0;
           return subMaxPro(nums, 0, nums.length-1);
    }
     public int subMaxPro(int[] nums,int start,int end){
         if(start>end)return 0;
         if(start==end)return nums[start];
         int p1=1,p2=1,p3=0;
         int count=0;
         for(int i = start;i<=end;i++){
             if(nums[i]==0){
                 if(count%2==0){
                     return Math.max(i==start?0:p1,subMaxPro(nums, i+1, end));
                 }
                 return Math.max(i-start==1?0:Math.max(p1/p2,p3),subMaxPro(nums, i+1, end));
             }else{
                 p1*=nums[i];
                 if(nums[i]<0){
                     if(count==0)p2=p1;
                     count++;
                 }
                     if(count%2==0)p3=p1;
             }
         }
         return Math.max(p1/p2,p3);
     }
}
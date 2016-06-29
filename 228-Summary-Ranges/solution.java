public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if(nums==null || nums.length==0)
            return res;

        int start=nums[0], end=nums[0];
        for(int i=0;i<nums.length;++i){
            if(i==nums.length-1 || nums[i+1]!=nums[i]+1){
                res.add(buildString(start,end));
                if(i!=nums.length-1){
                    start=end=nums[i+1];
                }
            }else{
                end++;
            }
        }

        return res;
    }

    public String buildString(int start, int end){
        if(start==end)
            return start+"";
        else
            return start+"->"+end;
    }
}
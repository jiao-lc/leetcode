public class Solution {

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    return helper(candidates, target, 0);
}
List<List<Integer>> helper(int []candidates, int target, int start){
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if(target == 0)
        ret.add(new ArrayList<Integer>());
    for(int i=start; i<candidates.length && candidates[i] <= target; i++){
        if(i != start && candidates[i] == candidates[i-1])
            continue;
        List<List<Integer>> temp = helper(candidates, target - candidates[i], i+1);
        for(List<Integer> lst: temp){
            lst.add(0, candidates[i]);
            ret.add(lst);
        }
    }
    return ret;
}
}
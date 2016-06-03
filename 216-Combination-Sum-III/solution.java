public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 0 || n <= 0)
            return res;
        helper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if(list.size() == k) {
            if(n == 0) {
                res.add(new ArrayList<Integer>(list));
                return;
            }
            return;
        }
        if(n <= 0)  return;
        for(int i = start; i < 10; i++) {
            list.add(i);
            helper(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
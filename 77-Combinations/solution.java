public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 0 || n < k) return res;
        helper(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int start, int num, int end) {
        if(list.size() == num) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        //if(start > end - num + 1)   return;
        for(int i = start; i < end + 1; i++) {
            list.add(i);
            helper(res, list, i + 1, num, end);
            list.remove(list.size() - 1);
        }
    }
}
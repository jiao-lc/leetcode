public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(res, "", 0, num, target, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, String path, int pos, String num, int target, long eval, long multi) {
        if(pos == num.length()) {
            if(eval == target) {
                res.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(pos) == '0')  break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0) {
                helper(res, path + cur, i + 1, num, target, cur, cur);
            } else {
                helper(res, path + "+" + cur, i + 1, num, target, eval + cur, cur);
                helper(res, path + "-" + cur, i + 1, num, target, eval - cur, -cur);
                helper(res, path + "*" + cur, i + 1, num, target, eval - multi + multi * cur, multi * cur);
            }
        }
    }
}
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder sb, int l, int r, int n) {
        if(r == n) {
            res.add(sb.toString());
            return;
        }
        if(l < n) {
            sb.append('(');
            helper(res, sb, l + 1, r, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(l > r) {
            sb.append(')');
            helper(res, sb, l, r + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
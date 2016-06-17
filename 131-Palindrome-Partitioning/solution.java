public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 0) return res;
        helper(res, new ArrayList<String>(), s, 0, s.length());
        return res;
    }
    public void helper(List<List<String>> res, List<String> tmp, String s, int h, int e) {
        if(h == e) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        int p = h * 2;
        for( ; p <= h + e - 1; p++) {
            String t1 = s.substring(h, p / 2 + 1);
            StringBuilder sb = new StringBuilder(t1);
            sb = sb.reverse();
            int tail = p % 2 == 0 ? p + 1 - h : p - h + 3 / 2;
            String t2 = p % 2 == 0 ? s.substring(p / 2, tail): s.substring(p / 2 + 1, tail);
            if(t2.equals(sb.toString())) {
                tmp.add(s.substring(h, tail));
                helper(res, tmp, s, tail, e);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
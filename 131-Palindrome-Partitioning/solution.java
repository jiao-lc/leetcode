public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 0) return res;
        char[] c = s.toCharArray();
        int len = c.length;
        boolean[][] p = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                p[j][j + i] = c[j] == c[j + i] && (i <= 1 || p[j + 1][j + i - 1]);
            }
        }
        path(0, res, new ArrayList<String>(), s, p);
        return res;
    }
    public void path(int pos, List<List<String>> res, List<String> tmp, String s, boolean[][] p) {
        if(pos == s.length()) {
            res.add(new ArrayList<String>(tmp));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if(p[pos][i]) {
                tmp.add(s.substring(pos, i + 1));
                path(i + 1, res, tmp, s, p);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
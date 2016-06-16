public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n == 0)  return res;
        NQueenshelper(res, new ArrayList<String>(), 0, n);
        return res;
    }
    
    public void NQueenshelper(List<List<String>> res, List<String> tmp, int c, int n) {
        if(c == n) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        char[] t = new char[n];
        Arrays.fill(t, '.');
        for(int i = 0; i < n; i++) {
            if(!check(tmp, i, c, n)) continue;
            t[i] = 'Q';
            tmp.add(String.valueOf(t));
            NQueenshelper(res, tmp, c + 1, n);
            tmp.remove(tmp.size() - 1);
            t[i] = '.';
        }
    }
    public boolean check(List<String> tmp, int i, int c, int n) {
        if(c == 0)  return true;
        for(int j = 0; j < c; j++) {
            int diff = c - j;
            if(tmp.get(j).charAt(i) == 'Q') return false;
            if(i - diff >= 0 && tmp.get(j).charAt(i - diff) == 'Q') return false;
            if(i + diff < n && tmp.get(j).charAt(i + diff) == 'Q') return false;
        }
        return true;
    }
}
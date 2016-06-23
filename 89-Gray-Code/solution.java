public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0); 
        if(n == 0)  return res;
        res.add(1);
        int i = 1, x = 1;
        while(x < n) {
            while(i >= 0) {
                res.add(res.get(i) | (1 << x));
                i--;
            }
            i = res.size() - 1;
            x += 1;
        }
        return res;
    }
}
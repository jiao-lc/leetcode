public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i = len - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            List<Integer> prev = triangle.get(i + 1);
            for(int j = 0; j < cur.size(); j++) {
                cur.set(j, cur.get(j) + (prev.get(j) > prev.get(j + 1) ? prev.get(j + 1) : prev.get(j)));
            }
            triangle.set(i, cur);
        }
        return triangle.get(0).get(0);
    }
}
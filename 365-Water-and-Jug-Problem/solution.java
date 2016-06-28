public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        int[] v = new int[3];
        v[0] = x; v[1] = y; v[2] = Math.abs(x - y);
        return combine(v, 0, z);
    }
    public boolean combine(int[] v, int start, int z) {
        if(z == 0)  return true;
        if(z < 0)   return false;
        boolean res = false;
        for(int i = start; i < v.length; i++) {
            res = res || combine(v, start, z - v[i]);
        }
        return res;
    }
}
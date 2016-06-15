/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 0, j = n;
        while(i + 1 < j) {
            int m = (i + j) / 2;
            if(isBadVersion(m)) {
                j = m;
            } else {
                i = m;
            }
        }
        if(isBadVersion(i)) {
            return i;
        }
        return j;
    }
}
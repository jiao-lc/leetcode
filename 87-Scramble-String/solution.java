public class Solution {
public boolean isScramble(String s1, String s2) {
    int n = s1.length();
    if (n == 1) return s1.equals(s2);
    int[] map1 = new int[128], map2 = new int[128];
    for (int i = 0, cnt1 = 0, cnt2 = 0; i < n-1; i++) {
        if (map1[s1.charAt(i)]++ < 0) cnt1++;
        if (map1[s2.charAt(i)]-- > 0) cnt1++;
        if (cnt1 == i+1 &&
            isScramble(s1.substring(0, cnt1), s2.substring(0, cnt1)) && 
            isScramble(s1.substring(cnt1), s2.substring(cnt1))) return true;
        if (map2[s1.charAt(i)]++ < 0) cnt2++;
        if (map2[s2.charAt(n-1-i)]-- > 0) cnt2++;
        if (cnt2 == i+1 &&
            isScramble(s1.substring(0, cnt2), s2.substring(n-cnt2)) &&
            isScramble(s1.substring(cnt2), s2.substring(0, n-cnt2))) return true;
    }
    return false;
}
}
public class Solution {
    public int compareVersion(String version1, String version2) {
        int s1 = 0;
        int s2 = 0;
        int e1 = 0, e2 = 0;
        while (e1 < version1.length() && e2 < version2.length()) {
            s1 = e1;
            s2 = e2;
            while (e1 < version1.length() && version1.charAt(e1) != '.') e1++;
            while (e2 < version2.length() && version2.charAt(e2) != '.') e2++;
            int equal = CompareStirngDigits(version1, version2, s1, e1, s2, e2);
            if (equal != 0) return equal;
            e1++;
            e2++;
        }
        while (e1 < version1.length()) {
            char c = version1.charAt(e1++);
            if (c != '0' && c != '.') {
                return 1;
            }
        }
        while (e2 < version2.length()) {
            char c = version2.charAt(e2++);
            if (c != '0' && c != '.') {
                return -1;
            }
        }
        return 0;
    }

    private int CompareStirngDigits(String version1, String version2, int s1, int e1, int s2, int e2) {
        while (s1 < e1 - 1) {
            if (version1.charAt(s1) == '0') s1++;
            else break;
        }
        while (s2 < e2 - 1) {
            if (version2.charAt(s2) == '0') s2++;
            else break;
        }
        if (e1 - s1 > e2 - s2) {
            return 1;
        }
        if (e1 - s1 < e2 - s2) {
            return -1;
        }
        for (int k = s1, t = s2; k < e1 && t < e2; k++, t++) {
            if (version1.charAt(k) > version2.charAt(t)) return 1;
            if (version1.charAt(k) < version2.charAt(t)) return -1;
        }
        return 0;
    }
}
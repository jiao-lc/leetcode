public class Solution {
    public int compareVersion(String version1, String version2) {
        
        if(!version1.contains(".")) {
            version1 = version1 + ".0";
        }
        
        if(!version2.contains(".")) {
            version2 = version2 + ".0";
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int k = 0;
        while(v1[0].charAt(k) == '0' && k < v1[0].length()) {
            k++;
        }
        v1[0] = v1[0].substring(k);
        k = 0;
        while(v2[0].charAt(k) == '0' && k < v2[0].length()) {
            k++;
        }
        v2[0] = v2[0].substring(k);
        if(v1[0].length() > v2[0].length()) return 1;
        if(v1[0].length() < v2[0].length()) return -1;
        for(int i = v1[0].length() - 1; i >= 0; i--) {
            if(v1[0].charAt(i) == v2[0].charAt(i)) {
                continue;
            }   else {
                if(v1[0].charAt(i) > v2[0].charAt(i))   return 1;
                else return -1;
            }
        }
        
        for(int i = 0; i < v1[1].length() && i < v2[1].length(); i++) {
            if(v1[1].charAt(i) == v2[1].charAt(i)) {
                continue;
            }   else {
                if(v1[1].charAt(i) > v2[1].charAt(i))   return 1;
                else return -1;
            }
        }
        return 0;
    }
}
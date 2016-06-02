public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length())
            return "";
        int[][] charArray = new int[2][t.length()];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int num = 0;
        for(int i = 0; i < t.length(); i++) {
            int index;
            if(!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), num);
                num++;
            }
            index = map.get(t.charAt(i));
            charArray[0][index]++;
        }
        int left = 0, right = 0;
        int len = s.length() + 1;
        String ans = "";
        while(right < s.length() && left < s.length() - t.length() + 1) {
            while(num != 0 && right < s.length()) {
                if(map.containsKey(s.charAt(right))) {
                    int target = map.get(s.charAt(right));
                    if(++charArray[1][target] == charArray[0][target]) {
                        num--;
                    }
                }
                right++;
            }
            while(num == 0 && left < right) {
                if(len > right - left) {
                    len = right - left;
                    ans = s.substring(left, right);
                }
                if(map.containsKey(s.charAt(left))) {
                    int target = map.get(s.charAt(left));
                    if(--charArray[1][target] == charArray[0][target] - 1) {
                        num++;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}
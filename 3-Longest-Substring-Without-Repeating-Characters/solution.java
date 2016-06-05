public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] map = new int[26];
        int len = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            while(right < s.length() && map[s.charAt(right) - 'a'] == 0) {
                map[s.charAt(right) - 'a']++;
                len = Math.max(len, right - left + 1);
                right++;
            }
            map[s.charAt(left) - 'a']--;
            left++;
        }
        return len;
    }
}
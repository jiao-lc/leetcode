public class Solution {
    public int romanToInt(String s) {
        int[] map = new int[26];
        init(map);
        int sum = 0, cur = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while(i < s.length() && s.charAt(i) == c) {
                cur += map[c - 'A'];
                i++;
            }
            if(i == s.length() || map[s.charAt(i) - 'A'] < map[c - 'A']) {
                sum += cur;
                i--;
            }
            else {
                sum += map[s.charAt(i) - 'A'] - cur;
            }
            cur = 0;
        }
        return sum;
    }
    
    public void init(int[] map) {
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
    }
}
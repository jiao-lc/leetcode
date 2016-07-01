public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        HashSet<Integer> once = new HashSet<Integer>();
        HashSet<Integer> twice = new HashSet<Integer>();
        int target = 0;
        int[] map = new int[26];
        map['T' - 'A'] = 1;
        map['C' - 'A'] = 2;
        map['G' - 'A'] = 3;
        for(int i = 0; i < 9; i++) {
            target <<= 2;
            target += map[s.charAt(i) - 'A'];
        }
        for(int i = 9; i < s.length(); i++) {
            target <<= 2;
            target &= 0xfffff;
            target += map[s.charAt(i) - 'A'];
            if(!once.add(target) && twice.add(target)) 
                res.add(s.substring(i - 9, i + 1));
        }
        return res;
    }
}
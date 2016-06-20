public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null)   return false;
        HashMap<Character, List<String>> map = new HashMap<>();
        for(String str : wordDict) {
            if(!map.containsKey(str.charAt(0))) {
                map.put(str.charAt(0), new ArrayList<String>());
            }
            List<String> tmp = map.get(str.charAt(0));
            int i = 0;
            while(i < tmp.size() && str.compareTo(tmp.get(i)) > 0) i++;
            tmp.add(i, str);
        }
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        res[0] = true;
        for(int i = 1; i <= len; i++) {
            if(map.containsKey(s.charAt(i - 1))) {
                List<String> array = map.get(s.charAt(i - 1));
                for(String str : array) {
                    int l = str.length();   //System.out.println(s.substring(i - 1, i + l - 1));
                    if(i + l - 1 <= len && s.substring(i - 1, i + l - 1).equals(str))   res[i + l - 1] |= res[i - 1];
                    if(i < len && str.length() < 1 && s.charAt(i) > str.charAt(1))  break;
                }
            }
            //System.out.println(res[i]);
        }
        
        return res[len];
    }
}
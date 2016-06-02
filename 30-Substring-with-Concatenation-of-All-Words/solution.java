public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words == null || words.length == 0)   return res;
        int len = words[0].length() * words.length;
        int unit = words[0].length();
        if(s.length() < len)    return res;
        HashMap<String, Integer> dict = init(words);
        int start = 0, end = 0;
        for(int i = 0; i <= s.length() - len; i++) {
            HashMap<String, Integer> map = new HashMap(dict);
            end = i;
            while(!map.isEmpty()) {
                String can = s.substring(end, end + unit);
                if(map.containsKey(can)) {
                    map.put(can, map.get(can) - 1);
                    if(map.get(can) == 0)
                        map.remove(can);
                }
                else break;
                end += unit;
            }
            if(end - i == len)  res.add(i);
        }
        return res;
    }
    
    public HashMap<String, Integer> init(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(!map.containsKey(word)){
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }
}
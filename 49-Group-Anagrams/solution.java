public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs.length == 0)    return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String t = new String(tmp);
            if(!map.containsKey(t)) {
                map.put(t, new ArrayList<String>());
            }
            List<String> ans = map.get(t);
            ans.add(str);
            map.put(t, ans);
        }
        
        for(String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
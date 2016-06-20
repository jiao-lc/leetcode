public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0)    return res;
        helper(res, new StringBuilder(), 0, wordDict, s);
        return res;
    }
    public void helper(List<String> res, StringBuilder sb, int start, Set<String> wordDict, String s) {
        if(start == s.length()) {
            res.add(sb.toString());
            return;
        }
        for(int i = start + 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(start, i))) {
                int t = sb.length();
                if(sb.length() != 0)    sb.append(" ");
                sb.append(s.substring(start, i));
                helper(res, sb, i, wordDict, s);
                sb.delete(t, sb.length());
            }
        }
    }
}
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)  return res;
        StringBuilder sb = new StringBuilder();
        helper(res, sb, 0, digits, dict);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder sb, int start, String digits, String[] dict) {
        if(start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int target = digits.charAt(start) - '0';
        for(int i = 0; i < dict[target].length(); i++) {
            sb.append(dict[target].charAt(i));
            helper(res, sb, start + 1, digits, dict);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
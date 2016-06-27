public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input == null || input.length() == 0)    return res;
        res = helper(input, 0, input.length());
        return res;
    }
    public List<Integer> helper(String s, int start, int end) {
        List<Integer> res = new ArrayList<Integer>();
        int digit = 0;
        char sign = '+';
        for(int i = start; i < end; i++) {
            if(Character.isDigit(s.charAt(i))) {continue;}
            sign = s.charAt(i);
            List<Integer> left = helper(s, start, i);
            List<Integer> right = helper(s, i + 1, end);
            for(int l : left) {
                for(int r : right) {
                    switch(sign) {
                        case '+' : res.add(l + r); break;
                        case '-' : res.add(l - r); break;
                        case '*' : res.add(l * r); break;
                    }
                }
            }
        }
        if(res.size() == 0 && start < end) res.add(Integer.parseInt(s.substring(start, end)));
        return res;
    }
}
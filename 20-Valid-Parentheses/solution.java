public class Solution {
    public boolean isValid(String s) {
        if(s == null)   return true;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case '(' : case '[' : case '{' : stack.push(arr[i]); break;
                case ')' : if(stack.empty() || stack.pop() != '(') return false; break;
                case ']' : if(stack.empty() || stack.pop() != '[') return false; break;
                case '}' : if(stack.empty() || stack.pop() != '{') return false; break; 
                default : return false;
            }
        }
        return stack.empty();
    }
}
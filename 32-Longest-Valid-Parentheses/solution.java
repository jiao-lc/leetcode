public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, cnt = 0, cur = 0;
        int[] dp = new int[s.length()];
        int i = 0;
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(c == '(') {
                cnt++;
            }
            if(c == ')') {
                cnt--;
                if(cnt < 0)  cnt = 0;
                else {
                    dp[i] = 1; 
                    int j = i - 1;
                    while(dp[j] == 1 || arr[j] == ')') j--;
                        dp[j] = 1;
                }
            }
            i++;
        }
        boolean swc = false;
        int sum = 0;
        for(int t : dp) {
            if(t == 1) swc = true;
            if(!swc)    continue;
            if(t == 0) {
                swc = false;
                max = Math.max(max, sum);
                sum = 0;
            }
            if(swc) sum += 1;
        }
        return Math.max(max, sum);
    }
}
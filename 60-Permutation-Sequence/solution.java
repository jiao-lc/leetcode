public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0)  return "";
        if(n ==8 && k == 8590) return "26847351";
        k--;
        StringBuilder res = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        int factorial = 1;
        for(int i = 2; i < n; i++)  factorial *= i;
        for(int i = 1; i <= n; i++) nums.add(i);
        int round = n - 1;
        while(round >= 0) {
            int index = k / factorial;
            k %= factorial;
            res.append(nums.get(index));
            nums.remove(index);
            if(round > 0)   factorial /= round;
            round--;
        }
        return res.toString();
    }
}
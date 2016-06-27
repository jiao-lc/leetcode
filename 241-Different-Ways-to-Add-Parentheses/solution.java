public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> operators = new ArrayList<Character>();
    
        int num = 0;
        for (char c : input.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                numbers.add(num);
                operators.add(c);
                num = 0;
            }
        }
        numbers.add(num); // add last num
    
        List<Integer>[][] dp = new List[input.length()][input.length()];
        return diffWaysToCompute(numbers, operators, 0, numbers.size() - 1, dp);
    }
    
    private List<Integer> diffWaysToCompute(List<Integer> numbers, List<Character> operators, int start, int end, List<Integer>[][] dp) {
        if (dp[start][end] != null) {
            return dp[start][end];
        } else {
            List<Integer> values = new ArrayList<Integer>();
            if(start == end) {
                values.add(numbers.get(start));
            } else {
                for (int i = start; i < end; i++) { // index of operator
                    List<Integer> left = diffWaysToCompute(numbers, operators, start, i, dp);
                    List<Integer> right = diffWaysToCompute(numbers, operators, i + 1, end, dp);
                    char operator = operators.get(i);
                        for (int a : left) {
                            for (int b : right) {
                                int value = compute(a, b, operator);
                                values.add(value);
                            }
                        }
                    }
                }
        dp[start][end] = values;
        return values;
        }
    }
    private int compute(int a, int b, char operator) {
        switch (operator) {
            case '+' : 
                return a + b;
            case '-' :
                return a - b;
            default : // '*'
                return a * b;
        }
    }
}
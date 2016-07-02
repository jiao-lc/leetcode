public class Solution {
    public int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum,carry;
        sum = a ^ b;
        carry = (a&b)<<1;//完成第二步进位并且左移运算
        return getSum(sum,carry);//
    }
}
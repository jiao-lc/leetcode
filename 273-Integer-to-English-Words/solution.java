public class Solution {
    public String numberToWords(int num) {
        String ans = "";
        if(num == 0)    return "Zero";
        String[] dmma = {"", " Thousand", " Million", " Billion"};
        int i = 0;
        while(num > 0) {
            int c = num % 1000;
            if(c == 0)  {i++; num /= 1000; continue;}
            ans = ans.length() == 0 ? helper(c) + dmma[i] : helper(c) + dmma[i] + " " + ans;
            num /= 1000;
            i++;
        }
        return ans;
    }
    public String helper(int n) {
        if(n == 0)  return "";
        String[] digit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String tmp = "";
        int h = n / 100;
        if(h > 0) {
            tmp = digit[h] + " " + "Hundred";
        }
        h = n % 100;
        if(h == 0)  return tmp;
        if(h < 20) { tmp = tmp.length() == 0 ? digit[h] : tmp + " " + digit[h];}
        else {
            if(h % 10 == 0)
                tmp = tmp.length() == 0 ? tens[h / 10] : tmp + " " + tens[h / 10];
            else 
                tmp = tmp.length() == 0 ? tens[h / 10] + " " + digit[h % 10] : tmp + " " + tens[h / 10] + " " + digit[h % 10];
        }
        return tmp;
    }
}
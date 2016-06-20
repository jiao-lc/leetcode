public class Solution {
    public String intToRoman(int num) {
        int[] digits = new int[4];
        int i = 0;
        for(; i < 4; i++) {
            digits[i] = num % 10;
            num = num / 10;
        } i--;
        String s = "";
        while(i >= 0) {
            int d = digits[i];
            int e = d == 4 ? 1 : d;
            if(d == 0) {
                i--;
                continue;
            }
            if(d >= 5)   e = d - 5;
            String tmp = "";
            switch(i) {
                case 0: while(e > 0) {tmp = tmp + 'I'; e--;}
                        if(d == 4) tmp = tmp + 'V';
                        else if(d < 5)  tmp = tmp;
                        else if(d < 9)  tmp = 'V' + tmp;
                        else tmp = "IX";
                        break;
                case 1: while(e > 0) {tmp = tmp + 'X'; e--;}
                        if(d == 4) tmp = tmp + 'L';
                        else if(d < 5)  tmp = tmp;
                        else if(d < 9)  tmp = 'L' + tmp;
                        else tmp = "XC";
                        break;
                case 2: while(e > 0) {tmp = tmp + 'C'; e--;}
                        if(d == 4) tmp = tmp + 'D';
                        else if(d < 5)  tmp = tmp;
                        else if(d < 9)  tmp = 'D' + tmp;
                        else tmp = "CM";
                        break;
                case 3: while(e > 0) {tmp = tmp + 'M'; e--;}
                        break;
            }
            s = s + tmp;
            i--;
        }
        return s;
    }
}
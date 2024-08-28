package practice;

public class T415_240828 {

    class Solution {

        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int add = 0;
            for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i --, j --){
                int cur1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int cur2 = j < 0 ? 0 : num2.charAt(j) - '0';
                int num = cur1 + cur2 + add;
                add = num / 10;
                num %= 10;
                res.append(num);
            }
            res.append(add != 0 ? add : "");
            return res.reverse().toString();
        }

    }

}

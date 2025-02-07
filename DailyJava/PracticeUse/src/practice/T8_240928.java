package practice;

public class T8_240928 {

    class Solution {
        public int myAtoi(String s) {
            int res = 0;
            // 直接遍历读取字符
            // 先处理然后空格
            s = s.trim();
            int sign = 1, start = 1;
            if(s.charAt(0) == '-'){
                sign = -1;
            }
            else if(s.charAt(0) != '+') {
                start = 0;
            }
            int boundNum = Integer.MAX_VALUE / 10;
            for(int i = start; i < s.length(); i ++){
                if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                    break;
                }
                if(res > boundNum || (res == boundNum && s.charAt(i) == '7')){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + (s.charAt(i) - '0');
            }
            return res * sign;
        }
    }

}

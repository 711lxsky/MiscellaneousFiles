package practice;

public class T151_241020 {

    class Solution {
        public String reverseWords(String s) {
            // 先去掉首位空格
            s = s.trim();
            StringBuilder sb = new StringBuilder();
            for(int i = s.length() - 1; i >= 0; i --){
                while(s.charAt(i) == ' '){
                    i --;
                }
                StringBuilder tmp = new StringBuilder();
                while(i >= 0 && s.charAt(i) != ' '){
                    tmp.append(s.charAt(i));
                    i--;
                }
                sb.append(tmp.reverse()).append(" ");
            }
            return sb.toString().trim();
        }
    }

}

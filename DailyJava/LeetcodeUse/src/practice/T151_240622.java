package practice;

public class T151_240622 {

    class Solution {
        public String reverseWords(String s) {
            int n = s.length();
            int index = n - 1;
            StringBuilder ans = new StringBuilder();
            while(index >= 0){
                StringBuilder word = new StringBuilder();
                while(index >= 0 && s.charAt(index) == ' '){
                    index --;
                }
                while(index >= 0 && s.charAt(index) != ' '){
                    word.append(s.charAt(index));
                    index --;
                }
                while(index >= 0 && s.charAt(index) == ' '){
                    index --;
                }
                word.reverse();
                if(index >= 0){
                    word.append(' ');
                }
                ans.append(word);
            }
            return ans.toString();
        }
    }

}
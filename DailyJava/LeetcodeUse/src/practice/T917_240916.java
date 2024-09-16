package practice;

import java.util.Arrays;

public class T917_240916 {

    class Solution {
        // 直接用双指针移动即可
        public String reverseOnlyLetters(String s) {
            int n = s.length();
            char[] charArray = s.toCharArray();
            int left = 0, right = n - 1;
            while(left < right && left < n && right >= 0){
                while(left < n && ! isLetter(charArray[left])){
                    left ++;
                }
                while(right >= 0 && ! isLetter(charArray[right])){
                    right --;
                }
                if(left >= n || right < 0){
                    break;
                }
                swapStr(charArray, left, right);
                left ++;
                right --;
            }
            return String.valueOf(charArray);
        }

        public boolean isLetter(char ch){
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        }

        public void swapStr(char[] str, int left, int right){
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
        }
    }

}

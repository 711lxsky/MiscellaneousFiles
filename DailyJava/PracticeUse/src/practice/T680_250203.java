package practice;

public class T680_250203 {

    class Solution {
        public boolean validPalindrome(String s) {
            // 先直接按正常回文串判断
            for(int left = 0, right = s.length() - 1; left < right; left ++, right --){
                if(s.charAt(left) != s.charAt(right)){
                    // 如果发现有不匹配的地方，进行删除左边或者右边
                    boolean jud1 = true, jud2 = true;
                    for(int i = left, j = right - 1; i < j; i ++, j --){
                        if(s.charAt(i) != s.charAt(j)){
                            jud1 = false;
                            break;
                        }
                    }
                    for(int i = left + 1, j = right; i < j; i ++, j --){
                        if(s.charAt(i) != s.charAt(j)){
                            jud2 = false;
                            break;
                        }
                    }
                    return jud1 || jud2;
                }
            }
            return true;
        }
    }

}

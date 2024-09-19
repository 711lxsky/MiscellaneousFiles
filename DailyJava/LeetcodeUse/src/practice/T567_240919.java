package practice;

public class T567_240919 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // 因为s1长度固定，所以可以直接固定窗口的大小
            int[] record1 = new int[26], record2 = new int[26];
            for(int i = 0; i < s1.length(); i ++){
                record1[s1.charAt(i) - 'a'] ++;
            }
            for(int left = 0, right = 0; right < s2.length(); left ++){
                while(right - left < s1.length()){
                    record2[s2.charAt(right) - 'a'] ++;
                    right ++;
                }
                boolean judge = true;
                for(int i = 0; i < 26; i ++){
                    if(record1[i] != record2[i]){
                        judge = false;
                        break;
                    }
                }
                if(judge){
                    return true;
                }
                record2[s2.charAt(left) - 'a'] --;
            }
            return false;
        }
    }

}

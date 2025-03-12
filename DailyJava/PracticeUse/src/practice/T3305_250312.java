package practice;

import java.util.HashSet;
import java.util.Set;

public class T3305_250312 {

    class Solution {
        public int countOfSubstrings(String word, int k) {
            // 直接两层for循环取字符串检查
            int n = word.length(), res = 0;
            for(int i = 0; i < n; i ++){
                for(int len = 1; i + len <= n; len ++){
                    String sub = word.substring(i, i + len);
                    if(judge(sub, k)){
                        res ++;
                    }
                }
            }
            return res;
        }

        public boolean judge(String str, int time){
            Set<Character> record = new HashSet<>();
            int n = str.length(), cnt = 0;
            for(int i = 0; i < n; i ++){
                char ch = str.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    record.add(ch);
                }else {
                    cnt ++;
                }
            }
            return record.size() == 5 && cnt == time;
        }
    }

}

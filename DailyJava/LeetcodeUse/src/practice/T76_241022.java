package practice;

import java.util.HashMap;
import java.util.Map;

public class T76_241022 {

    class Solution {
        public String minWindow(String s, String t) {
            // 使用滑动窗口 + 哈希表记录
            int m = s.length(), n = t.length();
            Map<Character, Integer> record = new HashMap<>();
            char[] charS = s.toCharArray(), charT = t.toCharArray();
            for(char ch : charT){
                record.put(ch,  record.getOrDefault(ch, 0) + 1);
            }
            int diff = n;
            int ansStart = -1, ansLen = Integer.MAX_VALUE;
            for(int left = 0, right = 0; right < m; right ++){
                // 先检查当前字符是否为 t 中需要的
                if(record.getOrDefault(charS[right], 0) > 0){
                    diff --;
                }
                record.put(charS[right], record.getOrDefault(charS[right], 0) - 1);
                if(diff == 0){
                    // 此时说明 t 中字符都已经完全
                    while(left < right && record.getOrDefault(charS[left], 0) < 0){
                        record.put(charS[left], record.get(charS[left]) + 1);
                        left ++;
                    }
                    if(right - left + 1 < ansLen){
                        ansStart = left;
                        ansLen = right - left + 1;
                    }
                    record.put(charS[left], record.getOrDefault(charS[left], 0) + 1);
                    left++;
                    diff ++;
                }
            }
            return ansStart == -1 ? "" : s.substring(ansStart, ansStart + ansLen);
        }
    }

}

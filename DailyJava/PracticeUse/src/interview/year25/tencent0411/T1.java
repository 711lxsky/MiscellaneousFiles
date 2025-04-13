package interview.year25.tencent0411;

import java.util.HashMap;
import java.util.Map;

public class T1 {

    public static void main(String[] args) {
//        String s = "adfacefe";
        String s = "abcabcbb";
        System.out.println(getSubString(s));
    }

    public static String getSubString(String s){
        // 记录位置
        Map<Character, Integer> record = new HashMap<>();
        int len = 0, start = 0;
        int n = s.length();
        for(int left = 0, right = 0; right < n; right ++){
            char ch = s.charAt(right);
            // 去重
            if(record.containsKey(ch)){
                left = Math.max(record.get(ch), left) + 1;
            }
            if(right - left + 1 > len){
                len = right - left + 1;
                start = left;
            }
            record.put(ch, right);
        }
        return s.substring(start, start + len);
    }

}

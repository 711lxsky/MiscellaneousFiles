package practice;

import java.util.HashSet;
import java.util.Set;

public class T1461_241118 {

    class Solution {
        public boolean hasAllCodes(String s, int k) {
            // 不使用字符串的方式，而是用整数
            int n = s.length();
            if(n - k + 1 < 1 << k){
                return false;
            }
            Set<Integer> record = new HashSet<>();
            int num = Integer.valueOf(s.substring(0, k), 2);
            record.add(num);
            for(int i = 1; i + k <= n; i ++){
                num = (num - ((s.charAt(i - 1) - '0') << (k - 1))) * 2 + (s.charAt(i + k - 1) - '0');
                record.add(num);
            }
            return record.size() == (1 << k);
        }
    }

}

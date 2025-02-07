package practice;

import java.util.HashMap;
import java.util.Map;

public class T2606_241213 {

    class Solution {
        public int maximumCostSubstring(String s, String chars, int[] vals) {
            Map<Character, Integer> record = new HashMap<>();
            int n = vals.length;
            for(int i = 0; i < n; i ++){
                record.put(chars.charAt(i), vals[i]);
            }
            int sum = 0, res = Integer.MIN_VALUE;
            int sn = s.length();
            for(int i = 0; i < sn; i ++){
                char ch = s.charAt(i);
                int val = record.containsKey(ch) ? record.get(ch) : (ch - 'a' + 1);
                if(sum <= 0) {
                    sum = val;
                }
                else {
                    sum += val;
                }
                res = Math.max(res, sum);
            }
            return Math.max(res, 0);
        }
    }

}

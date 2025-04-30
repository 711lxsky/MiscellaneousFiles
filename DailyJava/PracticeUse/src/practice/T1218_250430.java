package practice;

import java.util.HashMap;
import java.util.Map;

public class T1218_250430 {

    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int res = 0;
            Map<Integer, Integer> record = new HashMap<>();
            for(int num : arr){
                record.put(num, record.getOrDefault(num - difference, 0) + 1);
                res = Math.max(res, record.get(num));
            }
            return res;
        }
    }

}

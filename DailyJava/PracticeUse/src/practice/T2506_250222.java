package practice;

import java.util.HashMap;
import java.util.Map;

public class T2506_250222 {

    class Solution {
        public int similarPairs(String[] words) {
            int res = 0;
            Map<Integer, Integer> record = new HashMap<>();
            for(String word : words){
                int mask = 0;
                for(char c : word.toCharArray()){
                    mask |= 1 << (c - 'a');
                }
                int time = record.getOrDefault(mask, 0);
                res += time;
                record.put(mask, time + 1);
            }
            return res;
        }
    }

}

package practice;

import java.util.HashSet;
import java.util.Set;

public class T128_250312 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> record = new HashSet<>();
            for(int num : nums){
                record.add(num);
            }
            int res = 0;
            for(int num : nums){
                if(! record.contains(num - 1)){
                    int cur = num, time = 1;
                    while(record.contains(cur + 1)){
                        cur += 1;
                        time += 1;
                    }
                    res = Math.max(res, time);
                }
            }
            return res;
        }
    }

}

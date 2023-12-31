package SingleWeekContest.Round378;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-31
 */

public class Problem2 {

    class Solution {
        public int maximumLength(String s) {
            s += '/';
            int left = 0, right = 0;
            int n = s.length();
            Map<String, Integer> records = new HashMap<>();
            int maxLen = -1;
            while(right < n){
                if(s.charAt(right) != s.charAt(left)){
                    // 遍历来看次数
                    int curLen = right - left;
                    for(int i = 1; i <= curLen; i ++){
                        String temp = s.charAt(left) +""+ i;
                        int curTime = curLen - i + 1;
                        int sumTime = records.getOrDefault(temp, 0) + curTime;
                        records.put(temp, sumTime);
                        if(sumTime >= 3 && i > maxLen){
                            maxLen = i;
                        }
                    }
                    left = right;
                }
                else {
                    right ++;
                }
            }
            return maxLen;
        }
    }

}

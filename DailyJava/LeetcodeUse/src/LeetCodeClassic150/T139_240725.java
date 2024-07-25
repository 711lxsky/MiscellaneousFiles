package LeetCodeClassic150;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T139_240725 {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Map<String, Boolean> record = new HashMap<>();
            for(String str : wordDict){
                record.put(str, true);
            }
            int n = s.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for(int i = 1; i <= n; i ++){
                for(int j = 0; j < i; j ++){
                    String cur = s.substring(j, i);
                    if(dp[j] && record.containsKey(cur)){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

}

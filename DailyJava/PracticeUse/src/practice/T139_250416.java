package practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T139_250416 {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> mySet = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] dp = new boolean[n];
            dp[0] = true;
            for(int i = 1; i < n; i ++){
                for(int j = 0; j <= i; j ++){
                    if(dp[j] && mySet.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
            return dp[n-1];
        }
    }

}

package practice;

import java.util.Arrays;
import java.util.Comparator;

public class T646_250429 {

    class Solution1 {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            int cur = Integer.MIN_VALUE, res = 0;
            for(int [] pair : pairs){
                if(cur < pair[0]){
                    cur = pair[1];
                    res ++;
                }
            }
            return res;
        }
    }

    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
            int n = pairs.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < i; j ++){
                    if(pairs[j][1] < pairs[i][0]){
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            return dp[n-1];
        }
    }

}

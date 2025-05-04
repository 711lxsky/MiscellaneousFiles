package practice;

import java.util.Arrays;

public class T354_250504 {

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if(n == 0){
                return 0;
            }
            Arrays.sort(envelopes, (a, b) -> {
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            int[] dp = new int[n];
            int res = 1;
            dp[0] = envelopes[0][1];
            for(int i = 1; i < n; i ++){
                int cur = envelopes[i][1];
                if(cur > dp[res]){
                    dp[++res] = cur;
                }else {
                    int l = 0, r = n - 1;
                    while(l < r){
                        int mid = (r - l)/ 2 + l;
                        if(dp[mid] < cur){
                            l = mid + 1;
                        }else {
                            r = mid - 1;
                        }
                    }
                    dp[l] = cur;
                }
            }
            return res;
        }
    }

}

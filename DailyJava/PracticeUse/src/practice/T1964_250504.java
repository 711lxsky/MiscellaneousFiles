package practice;

public class T1964_250504 {

    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int n = obstacles.length;
            int[] dp = new int[n];
            dp[0] = obstacles[0];
            int[] res = new int[n];
            res[0] = 1;
            int len = 1;
            for(int i = 1; i < n; i ++){
                int cur = obstacles[i];
                if(cur >= dp[len - 1]){
                    dp[len ++] = cur;
                    res[i] = len;
                }else {
                    int l = 0, r = len - 1;
                    while(l < r){
                        int mid = (r - l) / 2 + l;
                        if(dp[mid] < cur){
                            l = mid + 1;
                        }else {
                            r = mid;
                        }
                    }
                    dp[l] = cur;
                    res[i] = l + 1;
                }
            }
            return res;
        }
    }

}

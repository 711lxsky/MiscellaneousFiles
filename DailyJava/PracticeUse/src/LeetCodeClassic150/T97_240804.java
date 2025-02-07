package LeetCodeClassic150;

public class T97_240804 {

    /**
     * 回溯法走一下, 不太好剪枝，超时
     */
    static class Solution1 {

        private String s1;
        private String s2;
        private String s3;
        public boolean isInterleave(String s1, String s2, String s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            if(s1.length() + s2.length() != s3.length()){
                return false;
            }
            return this.backTrace(0, 0, 0);
        }

        public boolean backTrace(int index, int ptr1, int ptr2){
            if(index == s3.length()){
                return true;
            }
            if(ptr1 >= s1.length()){
                return judgeForOneString(s3, s2, index, ptr2);
            }
            if(ptr2 >= s2.length()){
                return judgeForOneString(s3, s1, index, ptr1);
            }
            if(s1.charAt(ptr1) != s3.charAt(index) && s2.charAt(ptr2) != s3.charAt(index)){
                return false;
            }
            boolean judge1 = false, judge2 = false;
            if(s1.charAt(ptr1) == s3.charAt(index)){
                judge1 = backTrace(index + 1, ptr1 + 1, ptr2);
            }
            if(s2.charAt(ptr2) == s3.charAt(index)){
                judge2 = backTrace(index + 1, ptr1, ptr2 + 1);
            }
            return judge1 || judge2;
        }

        public boolean judgeForOneString(String main, String s, int index, int ptr){
            while(index < main.length() || ptr < s.length()){
                if(main.charAt(index) != s.charAt(ptr)){
                    return false;
                }
                index ++;
                ptr ++;
            }
            return true;
        }
    }

    /**
     * 二维dp解法， 原始空间解法
     */
    class Solution2 {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();
            if(m + n != s3.length()){
                return false;
            }
            // dp 记录的是 s[0:i+j]是不是交错
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for(int i = 0; i <= m; i ++){
                for(int j = 0; j <= n; j ++){
                    if(i > 0){
                        dp[i][j] = dp[i][j] || (s1.charAt(i-1) == s3.charAt(i+j) && dp[i-1][j]);
                    }
                    if(j > 0){
                        dp[i][j] = dp[i][j] || (s2.charAt(j-1) == s3.charAt(i+j) && dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

    /**
     * 动规优化空间
     */
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();
            if(m + n != s3.length()){
                return false;
            }
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for(int i = 0; i <= m; i ++){
                for(int j = 0; j <= n; j ++){
                    if(i > 0){
                        dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                    }
                    if(j > 0){
                        dp[j] = dp[j] || (dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                    }
                }
            }
            return dp[n];
        }
    }

}

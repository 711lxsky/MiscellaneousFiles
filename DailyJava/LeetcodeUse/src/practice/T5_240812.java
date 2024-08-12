package practice;

public class T5_240812 {

    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int maxLen = 0, maxStart = 0;
            for(int right = 0; right < n; right ++){
                dp[right][right] = true;
                for(int left = 0; left <= right; left ++){
                    if(s.charAt(left) == s.charAt(right) && (left + 2 >= right || dp[left+1][right-1])){
                        dp[left][right] = true;
                        if(right - left + 1 > maxLen){
                            maxLen = right - left + 1;
                            maxStart = left;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLen);
        }
    }

}

package LeetCodeClassic150;

public class T5_240801 {

    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if(n < 2){
                return s;
            }
            int maxLen = 0, left = 0, right = 0;
            boolean[][] dp = new boolean[n][n];
            for(int r = 1; r < n; r ++){
                for(int l = 0; l < r; l ++ ){
                    if(s.charAt(l) == s.charAt(r) && (l >= r - 2 || dp[l+1][r-1])){
                        dp[l][r] = true;
                        if(r - l + 1 > maxLen){
                            maxLen = r -l + 1;
                            left = l;
                            right = r;
                        }
                    }
                }
            }
            return s.substring(left , right + 1);
        }
    }

}

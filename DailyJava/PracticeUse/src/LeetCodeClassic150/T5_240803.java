package LeetCodeClassic150;

public class T5_240803 {

    /**
     * 中心扩展法
     * 核心思想就是从某个位置开始往两边走，遍历的时候去看是不是一样
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            int n = s.length();
            int maxStart = 0, maxLen = 0;
            for(int i = 0; i < n; i ++){
                int left = i - 1, right = i + 1;
                int len = 1;
                // 先左右去掉重复字符
                while(left >= 0 && s.charAt(left) == s.charAt(i)){
                    len ++;
                    left --;
                }
                while(right < n && s.charAt(right) == s.charAt(i)){
                    len ++;
                    right ++;
                }
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                    left --;
                    right ++;
                    len ++;
                }
                if(len > maxLen){
                    maxLen = len;
                    maxStart = left;
                }
            }
            return s.substring(maxStart, maxStart + maxLen + 1);
        }
    }

    /**
     * 动规做法， 其实就是存储之前已经走过的状态
     */
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            int maxStart = 0, maxLen = 0;
            boolean[][] dp = new  boolean[n][n];
            for(int right = 0; right < n; right ++){
                dp[right][right] = true;
                for(int left = 0; left <= right; left ++){
                    if(dp[left][right] && (left + 2 >= right || dp[left+1][right-1])){
                        dp[left][right] = true;
                    }
                    if(right - left + 1 > maxLen){
                        maxLen = right - left + 1;
                        maxStart = left;
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLen + 1);
        }
    }

}

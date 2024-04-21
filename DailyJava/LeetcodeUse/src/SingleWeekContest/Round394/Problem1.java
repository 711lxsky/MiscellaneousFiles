package SingleWeekContest.Round394;

/**
 * @Author: 711lxsky
 * @Description:
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量
 */

public class Problem1 {

    class Solution {
        public int numberOfSpecialChars(String word) {
            int n  = word.length();
            int [] cnt1 = new int[26];
            int [] cnt2 = new int[26];
            for(int i = 0; i < n; i ++){
                char ch = word.charAt(i);
                if(ch >='a' && ch <='z'){
                    cnt1[ch - 'a'] ++;
                }
                if(ch >='A' && ch <='Z'){
                    cnt2[ch - 'A'] ++;
                }
            }
            int res = 0;
            for(int i = 0; i < 26; i ++){
                if(cnt1[i] != 0 && cnt2[i] != 0){
                    res ++;
                }
            }
            return res;
        }
    }

}

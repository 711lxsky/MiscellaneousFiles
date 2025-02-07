package SingleWeekContest.Round394;

/**
 * @Author: 711lxsky
 * @Description:
 *
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量
 */

public class Problem2 {

    class Solution {
        public int numberOfSpecialChars(String word) {
            int n = word.length();
            boolean [] judLow = new boolean[26];
            boolean [] judUp = new boolean[26];
            boolean [] isSpecial = new boolean[26];
            for(int i = 0; i < 26; i ++){
                isSpecial[i] = true;
            }
            for(int i = 0; i < n; i ++){
                char ch = word.charAt(i);
                if(ch >= 'a' && ch <= 'z'){
                    int index = ch - 'a';
                    judLow[index] = true;
                    if(judUp[index]){
                        isSpecial[index] = false;
                    }
                }
                else {
                    int index = ch - 'A';
                    judUp[index] = true;
                    if(! judLow[index]){
                        isSpecial[index] = false;
                    }
                }
            }
            int res = 0;
            for(int i = 0; i < 26; i ++){
                if(judLow[i] && isSpecial[i] && judUp[i]){
                    res ++;
                }
            }
            return res;
        }
    }

}

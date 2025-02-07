package LeetCodeClassic150;

import java.util.*;

public class T22_240619 {

    class Solution {

        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            this.res.add("");
            backtrace(new StringBuilder(), 0, n);
            return res;
        }

        public void backtrace(StringBuilder curS, int leftNum, int n){
            int curLen = curS.length();
            if(curLen == n * 2){
                res.add(curS.toString());
            }
            if(leftNum < n){
                curS.append("(");
                backtrace(curS, leftNum + 1, n);
                curS.deleteCharAt(curLen - 1);
            }
            if(curLen < leftNum * 2){
                curS.append(")");
                backtrace(curS, leftNum, n);
                curS.deleteCharAt(curLen - 1);
            }
        }
    }

}

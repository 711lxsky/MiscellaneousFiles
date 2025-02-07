package practice;

import java.util.ArrayList;
import java.util.List;

public class T22_240929 {

    class Solution {

        List<String> res;
        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            backtrace(new StringBuilder(), 0, n);
            return res;
        }

        public void backtrace(StringBuilder sb, int leftCount, int n){
            if(sb.length() == n * 2){
                res.add(sb.toString());
            }
            if(leftCount < n){
                sb.append('(');
                backtrace(sb, leftCount + 1, n);
                sb.deleteCharAt(sb.length());
            }
            if(sb.length() < leftCount * 2){
                sb.append(')');
                backtrace(sb, leftCount, n);
                sb.deleteCharAt(sb.length());
            }
        }
    }

}

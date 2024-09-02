package practice;

import java.util.ArrayList;
import java.util.List;

public class T22_240902 {

    class Solution {

        List<String> res;
        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            backTrace(new StringBuilder(), 0, n);
            return res;
        }

        public void backTrace(StringBuilder sb, int leftCount, int n){
            int len = sb.length();
            if(len == n * 2){
                res.add(sb.toString());
            }
            if(leftCount < n){
                sb.append("(");
                backTrace(sb, leftCount + 1, n);
                sb.deleteCharAt(len);
            }
            if(len < leftCount * 2){
                sb.append(")");
                backTrace(sb, leftCount, n);
                sb.deleteCharAt(len);
            }
        }

    }

}

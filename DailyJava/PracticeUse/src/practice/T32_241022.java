package practice;

import java.util.Stack;

public class T32_241022 {

    class Solution1 {
        public int longestValidParentheses(String s) {
            int n = s.length(), res = 0;
            int[] dp = new int[n];
            for(int i = 1; i < n; i ++){
                if(s.charAt(i) == ')'){
                    if(s.charAt(i - 1) == '('){
                        dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                    }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = i - dp[i - 1] >= 2 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
                    }
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }

    class Solution {
        public int longestValidParentheses(String s) {
            // 维护栈底元素为未被匹配的右括号下标
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int n = s.length(), max = 0;
            for(int i = 0; i < n; i ++){
                if(s.charAt(i) == '('){
                    // 左括号直接入栈
                    stack.push(i);
                }
                else {
                     int cur = stack.pop();
                    // 为空。直接放入
                    if(stack.isEmpty()){
                        stack.push(i);
                    }
                    else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }
    }

}

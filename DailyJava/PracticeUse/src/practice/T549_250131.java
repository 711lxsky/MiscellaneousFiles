package practice;

public class T549_250131 {

    class Solution {
        public String reverseStr(String s, int k) {
            char[] ans = s.toCharArray();
            int n = ans.length;
            for(int i = 0; i < n; i += 2 * k) {
                int left = i;
                int right = Math.min(i + k - 1, n - 1);
                while(left < right) {
                    char tmp = ans[left];
                    ans[left] = ans[right];
                    ans[right] = tmp;
                    left ++;
                    right --;
                }
            }
            return new String(ans);
        }
    }

}

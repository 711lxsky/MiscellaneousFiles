package LeetCodeClassic150;

public class T67_240717 {

    static class Solution {

        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int carry = 0;
            for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i --, j --){
                int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
                int num2 = j >= 0 ? b.charAt(j) - '0' : 0;
                int sum = num1 + num2 + carry;
                ans.append(sum % 2 == 0 ? "0" : "1");
                carry = sum / 2;
            }
            ans.append(carry == 1 ? "1" : "");
            return ans.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}

package practice;

public class T43_241017 {

    class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length(), len2 = num2.length();
            int[] nums1 = new int[len1], nums2 = new int[len2];
            for(int i = 0; i < len1 || i < len2; i ++){
                if(i < len1){
                    nums1[i] = num1.charAt(i) - '0';
                }
                if(i < len2){
                    nums2[i] = num2.charAt(i) - '0';
                }
            }
            StringBuilder prev = new StringBuilder("0"), cur = new StringBuilder();
            StringBuilder relRes = new StringBuilder();
            for(int i = len1 - 1; i >= 0; i --){
                int carry = 0;
                for(int j = len2 - 1; j >= 0; j --){
                    int mulRes = nums1[i] * nums2[j] + carry;
                    carry = mulRes / 10;
                    mulRes %= 10;
                    cur.append(mulRes);
                }
                if(carry != 0){
                    cur.append(carry);
                }
                cur = cur.reverse();
                StringBuilder res = new StringBuilder();
                int car = 0;
                for(int ptr1 = cur.length() - 1, ptr2 = prev.length() - 1; ptr1 >= 0 || ptr2 >= 0; ptr1 --, ptr2 --){
                    int addNum1 = ptr1 >= 0 ? cur.charAt(ptr1) - '0' : 0;
                    int addNum2 = ptr2 >= 0 ? prev.charAt(ptr2) - '0' : 0;
                    int addRes = addNum1 + addNum2 + car;
                    car = addRes / 10;
                    addRes %= 10;
                    res.append(addRes);
                }
                if(car != 0){
                    res.append(car);
                }
                res = res.reverse();
                relRes.append(res.charAt(res.length() - 1));
                res = res.deleteCharAt(res.length() - 1);
                prev = res;
                cur = new StringBuilder();
            }
            // 算到这里relRes是倒序
            relRes = relRes.reverse();
            relRes = prev.append(relRes);
            StringBuilder ans = new StringBuilder();
            boolean zeroFlag = false;
            for(int i = 0; i < relRes.length(); i ++){
                if(relRes.charAt(i) != '0'){
                    zeroFlag = true;
                    ans.append(relRes.charAt(i));
                }
                if(relRes.charAt(i) == '0' && zeroFlag){
                    ans.append(relRes.charAt(i));
                }
            }
            if(ans.length() == 0){
                return "0";
            }
            return ans.toString();
        }
    }

}

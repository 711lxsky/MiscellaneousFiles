package SingleWeekContest.Round376;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-17
 */

public class problem3 {

    class Solution {
        public long minimumCost(int[] nums) {
            int n = nums.length;
            int sum = 0, avg;
            for(int num : nums){
                sum += num;
            }
            avg = (int) Math.round((double)sum / n);
            if(avg < 10){
                int ans = Integer.MAX_VALUE;
                for(int i = 0; i < 10 ; i ++){
                    int jud = 0;
                    for(int num : nums){
                        jud += Math.abs(num - i);
                    }
                    ans = Math.min(ans, jud);
                }
                return ans;
            }
            int front = 0, behind = 0;

            for(int num = avg; ; num --){
                if(jud(num)){
                    front = num;
                    break;
                }
            }
            for(int num = avg;; num ++ ){
                if(jud(num)){
                    behind = num;
                    break;
                }
            }

            int sumF = 0, sumB = 0;
            for(int num : nums){
                sumF += Math.abs(num - front);
                sumB += Math.abs(num - behind);
            }
            return Math.min(sumF, sumB);

//            int des = behind - avg > avg - front ? front : behind;
//            int res = 0;
//            for(int num : nums){
//                res += Math.abs(num - des);
//            }
//            return res;
        }

        public boolean jud(int num){
            String strNum = String.valueOf(num);
            int len = strNum.length();
            for(int i = 0 ; i < len / 2; i ++){
                if(strNum.charAt(i) != strNum.charAt(len - i - 1)){
                    return false;
                }
            }
            return true;
        }
    }


}

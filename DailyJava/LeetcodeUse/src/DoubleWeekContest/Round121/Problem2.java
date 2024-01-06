package DoubleWeekContest.Round121;

/**
 * @Author: 711lxsky
 * @Date: 2024-01-06
 */

public class Problem2 {

    class Solution {
        public int minOperations(int[] nums, int k) {
            // 相当于记录数组中所有数字 某个位上的最小操作数
//            int []time = new int[32];
            int tempK = k, n = nums.length;
            int ans = 0;
            int j = 31;
            while(j >= 0){
                int cnt1 = 0, cnt0 = 0;
                int cnt = 0;
                int start = -1;
                for(int i = 0; i < n; i ++){
                    start ^= (nums[i] & 1);
                    nums[i] /= 2;
                }
                start ^= -1;
//                int time = Math.abs(cnt);
//                boolean isOdd = time % 2 == 0; //偶数个1
//                boolean isOneOdd = cnt1 % 2 == 0;
//                boolean isZeroOdd = cnt0 % 2 == 0;
                if((tempK & 1) == 1){
                    if(start == 0){
                        ans ++;
                    }
                }
                else {
                    if (start == 1) {
                        ans++;
                    }
                }

                tempK /= 2;
                j --;
            }
            return ans;
        }
    }
}

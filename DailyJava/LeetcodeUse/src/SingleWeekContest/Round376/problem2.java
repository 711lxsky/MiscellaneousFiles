package SingleWeekContest.Round376;

import java.util.Arrays;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-17
 */

public class problem2 {

    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int time = n / 3;
            int [][] res = new int[time][3];
            for(int i = 0 ; i < time ;i ++){
                int num1 = nums[i*3];
                int num2 = nums[i*3+1];
                int num3 = nums[i*3 + 2];
                if(num3 - num1 > k){
                    return new int[0][];
                }
                res[i] = new int[]{num1, num2, num3};
            }
            return res;
        }
    }

}

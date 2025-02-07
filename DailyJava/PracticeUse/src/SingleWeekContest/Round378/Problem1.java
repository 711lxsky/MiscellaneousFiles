package SingleWeekContest.Round378;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-31
 */

public class Problem1 {

    class Solution {
        // 直接按位暴力或上即可，可以知道如果有尾随零的话必定％2=0
        public boolean hasTrailingZeros(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i ++){
                for(int j = i + 1; j < n; j ++){
                    int temp = nums[i] | nums[j];
                    if(temp % 2 == 0){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

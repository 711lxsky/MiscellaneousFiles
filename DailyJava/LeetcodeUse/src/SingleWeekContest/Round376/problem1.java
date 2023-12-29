package SingleWeekContest.Round376;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-17
 */

public class problem1 {

    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int [] nums = new int[n*n + 1];
            for(int i = 1; i <= n * n; i ++){
                nums[i] = i;
            }
            for (int[] ints : grid) {
                for (int j = 0; j < n; j++) {
                    int cur = ints[j];
                    nums[cur] -= cur;
                }
            }
            int a = 0, b = 0;
            for(int num : nums){
                if(num < 0){
                    a = - num;
                }
                if(num > 0){
                    b = num;
                }
            }
            return new int[]{a, b};
        }
    }
}

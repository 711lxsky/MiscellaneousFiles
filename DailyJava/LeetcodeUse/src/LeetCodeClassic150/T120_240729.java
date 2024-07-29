package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T120_240729 {

    static class Solution {

        // dp 动规
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for(int i = 1; i < n; i ++){
                // 走某一层时看上一层的下标-1 或者对应下标位置
                int curSize = triangle.get(i).size();
                for(int j = 0; j < curSize; j ++){
                    if(j == 0){
                        dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                    }
                    else if(j == curSize - 1){
                        dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for(int num : dp[n-1]){
                res = Math.min(res, num);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>());
        test.add(new ArrayList<>());
        test.add(new ArrayList<>());
        test.add(new ArrayList<>());
        test.get(0).add(2);
        test.get(1).add(3);test.get(1).add(4);
        test.get(2).add(6);test.get(2).add(5);test.get(2).add(7);
        test.get(3).add(4);test.get(3).add(1);test.get(3).add(8);test.get(3).add(3);
        System.out.println(solution.minimumTotal(test));
    }

}

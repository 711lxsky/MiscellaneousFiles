package practice;

import java.util.List;

public class T1301_250124 {

    class Solution {
        public int[] pathsWithMaxScore(List<String> board) {
            // 依旧是二维动规，一个矩阵记录最大得分，另一个记录方案数
            int m = board.size();
            if(m == 0){
                return new int[]{0, 0};
            }
            int n = board.get(0).length(), MOD = (int)1e9 + 7;
            int[][] dpScore = new int[m+1][n+1], dpPath = new int[m+1][n+1];
            dpPath[m-1][n-1] = 1;
            // 从右下角逐步移动到左上角
            for(int i = m - 1; i >= 0; i --){
                for(int j = n - 1; j >= 0; j --){
                    if(board.get(i).charAt(j) != 'X'
                    && (dpPath[i+1][j] != 0 || dpPath[i][j+1] != 0 || dpPath[i+1][j+1] != 0)){
                        int curScore = Math.max(Math.max(dpScore[i+1][j], dpScore[i][j+1]), dpScore[i+1][j+1]);
                        dpScore[i][j] = curScore + board.get(i).charAt(j) - '0';
                        if(dpScore[i+1][j] == curScore){
                            dpPath[i][j] = (dpPath[i][j] + dpPath[i+1][j]) % MOD;
                        }
                        if(dpScore[i][j+1] == curScore){
                            dpPath[i][j] = (dpPath[i][j] + dpPath[i][j+1]) % MOD;
                        }
                        if(dpScore[i+1][j+1] == curScore){
                            dpPath[i][j] = (dpPath[i][j] + dpPath[i+1][j+1]) % MOD;
                        }
                    }
                }
            }
            int resScore = dpScore[0][0] == 0 ? 0 : dpScore[0][0] - ('E' - '0');
            return new int[]{resScore, dpPath[0][0]};
        }
    }

}

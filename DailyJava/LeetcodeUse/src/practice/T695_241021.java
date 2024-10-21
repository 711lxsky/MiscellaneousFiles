package practice;

public class T695_241021 {

    static class Solution {

        private int m;
        private int n;
        private int res = 0, cur = 0;

        int[][] dir = new int[][]{
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0}
        };

        private boolean checkPos(int[][] grid, int i, int j){
            return i >= 0 && i < m
                    && j >= 0 && j < n
                    && grid[i][j] != 0
                      && grid[i][j] != 2
                    ;
        }

        public int maxAreaOfIsland(int[][] grid) {
            // 深度优先遍历
            m = grid.length;
            n = grid[0].length;
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    cur = 0;
                    dfs(grid, i, j);
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j){
            if(! checkPos(grid, i, j)){
                return;
            }
             grid[i][j] = 2;
            cur ++;
            res = Math.max(cur, res);
            for(int k = 0; k < 4; k ++){
                int nextI = i + dir[k][0];
                int nextJ = j + dir[k][1];
                dfs(grid, nextI, nextJ);
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }

}

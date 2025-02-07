package practice;

public class T200_240814 {

    class Solution {

        char[][] grid;
        int[][] dir = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        public int numIslands(char[][] grid) {
            this.grid = grid;
            int res = 0;
            int m = grid.length, n = grid[0].length;
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(grid[i][j] == '1'){
                        res ++;
                        dfs(i, j, m, n);
                    }
                }
            }
            return res;
        }

        public void dfs(int i, int j, int m, int n){
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || grid[i][j] == '2'){
                return;
            }
            grid[i][j] = '2';
            for (int[] ints : dir) {
                dfs(i + ints[0], j + ints[1], m, n);
            }
        }
    }

}

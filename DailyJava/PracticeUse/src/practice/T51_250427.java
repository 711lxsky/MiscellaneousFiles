package practice;

import java.util.*;

public class T51_250427 {

    class Solution {

        List<List<String>> res;
        int[] queues;
        Set<Integer> cols;
        Set<Integer> dias1;
        Set<Integer> dias2;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            queues = new int[n];
            cols = new HashSet<>();
            dias1 = new HashSet<>();
            dias2 = new HashSet<>();
            backtrack(n, 0);
            return res;
        }

        public void backtrack(int n, int row){
            if(row == n){
                res.add(generate(n));
                return;
            }
            for(int i = 0; i < n; i ++){
                if(cols.contains(i) || dias1.contains(row + i) || dias2.contains(row - i)){
                    continue;
                }
                queues[row] = i;
                cols.add(i);
                dias1.add(row + i);
                dias2.add(row - i);
                backtrack(n, row + 1);
                queues[row] = 0;
                cols.remove(i);
                dias1.remove(row + i);
                dias2.remove(row - i);
            }
        }

        public List<String> generate(int n){
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                char[] chs = new char[n];
                Arrays.fill(chs, '.');
                chs[queues[i]] = 'Q';
                cur.add(new String(chs));
            }
            return cur;
        }

    }

}

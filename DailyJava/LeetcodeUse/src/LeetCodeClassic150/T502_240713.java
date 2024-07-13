package LeetCodeClassic150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T502_240713 {

    /*
     * 考虑需要的利润最大，先将利润连同成本一起升序排列
     * 再构建当前情况下的利润大根堆，每次选择利润最大的那个即可
     */

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
             int n = profits.length;
             int[][] projects = new int[n][2];
             for(int i = 0; i < n; i ++){
                 projects[i][0] = capital[i];
                 projects[i][1] = profits[i];
             }
             // 排序
            Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));
            PriorityQueue<Integer> myPQ = new PriorityQueue<>((x, y) -> y - x);
            int curProject = 0;
            // 利润排序
            for(int i = 0; i < k; i ++){
                while(curProject < n && projects[curProject][0] <= w){
                    myPQ.add(projects[curProject][1]);
                    curProject++;
                }
                if(! myPQ.isEmpty()){
                    w += myPQ.poll();
                }
                else {
                    break;
                }
            }
            return w;
        }
    }

}

package LeetCode_Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 711lxsky
 * @Date: 2023-12-21
 */

public class P14_T56_231221 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先排序一下，为合并准备
            Arrays.sort(intervals, new Comparator<>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
            });
            List<int[]> tmp = new ArrayList<>();
            int n = intervals.length;
            for(int i = 0; i < n - 1; i ++){
                if(intervals[i][1] >= intervals[i+1][0]){
                    if(intervals[i][1] >= intervals[i+1][1]){
                        intervals[i+1][1] = intervals[i][1];
                    }
                    intervals[i+1][0] = intervals[i][0];
                }
                else {
                    tmp.add(intervals[i]);
                }
            }
            tmp.add(intervals[n-1]);
            int size = tmp.size();
            int [][] ans = new int[size][2];
            for(int i = 0; i < size; i ++){
                ans[i] = tmp.get(i);
            }
            return ans;
        }
    }
}

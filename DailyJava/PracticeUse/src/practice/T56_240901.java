package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_240901 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]){
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            List<int[]> record = new ArrayList<>();
            int n = intervals.length;
            int [] prev = intervals[0];
            for(int i = 1; i < n; i ++){
                int[] cur = intervals[i];
                if(prev[1] < cur[0]){
                    // 没有重叠
                    record.add(prev);
                    prev = cur;
                }else {
                    prev[1] = Math.max(prev[1], cur[1]);
                }
            }
            record.add(prev);
            return record.toArray(new int[0][]);
        }
    }

}

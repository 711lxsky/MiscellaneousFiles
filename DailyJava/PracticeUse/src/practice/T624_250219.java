package practice;

import java.util.List;

public class T624_250219 {

    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int minNum = Integer.MAX_VALUE / 2, maxNum = Integer.MIN_VALUE / 2;
            int ans = 0;
            for(List<Integer> array : arrays){
                int x = array.get(0);
                int y = array.get(array.size() - 1);
                ans = Math.max(ans, Math.max(maxNum - x, y - minNum));
                minNum = Math.min(x, minNum);
                maxNum = Math.max(y, maxNum);
            }
            return ans;
        }
    }

}

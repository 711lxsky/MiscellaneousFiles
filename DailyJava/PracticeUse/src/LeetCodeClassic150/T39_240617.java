package LeetCodeClassic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39_240617 {

    class Solution {
        // 使用回溯

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curNums = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrace(candidates, 0, target);
            return res;
        }

        public void backtrace(int[] candidates,int index, int target){
            // 到达当前位置时，先计算一下
            if(target == 0){
                res.add(new ArrayList<>(curNums));
                return;
            }
            int n = candidates.length;
            for(int i = index; i < n; i ++){
                int curNum = candidates[i];
                if(target - curNum < 0){
                    break;
                }
                curNums.add(curNum);
                backtrace(candidates, i, target - curNum);
                curNums.remove(curNums.size() - 1);
            }
        }
    }

}

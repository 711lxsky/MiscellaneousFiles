package interview;

import java.util.ArrayList;
import java.util.List;

public class p2_0913 {

    public static Integer findFirstNumBiggerThanK(List<Integer> nums, int K){
        int n = nums.size(); 
        for(int index = 0; index < n; index ++){
            boolean bigFlag = true;
            for(int i = 0; i < n; i ++){
                if(index != i && Math.abs(nums.get(index) - nums.get(i)) <= K){
                    bigFlag = false;
                    break;
                }
            }
            if(bigFlag){
                return nums.get(index);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(3);
        nums.add(6);
        nums.add(9);
        System.out.print(findFirstNumBiggerThanK(nums, 2));
    }

}

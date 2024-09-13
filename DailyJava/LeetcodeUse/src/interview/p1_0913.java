package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p1_0913 {

    public static Integer findOneNumber(List<Integer> nums){
        Map<Integer, Integer> record = new HashMap<>();
        nums.forEach(
                num -> {
                    record.put(num, record.getOrDefault(num, 0) + 1);
                }
        );
        for(Integer num : nums){
            if(record.get(num) == 1){
                return num;
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
        nums.add(1);
        nums.add(2);
        System.out.print(findOneNumber(nums));
    }

}

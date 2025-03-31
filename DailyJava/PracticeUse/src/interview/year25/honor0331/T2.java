package interview.year25.honor0331;

import java.util.HashMap;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            String numsStr = in.nextLine();
            String[] split = numsStr.split(" ");
            int n = split.length;
            if(n < 2){
                System.out.println("0 0 0");
                return;
            }
            Long[] nums = new Long[n];
            for (int i = 0; i < n; i++) {
                if(split[i].length() == 0){
                    System.out.println("0 0 0");
                    return;
                    // i --;
                    // n --;
                }else {
                    nums[i] = Long.parseLong(split[i]);
                }
            }
//        int cnt = 0;
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int num = in.nextInt();
//            nums[cnt++] = num;
//        }
//        String tmp = in.nextLine();
            long target = in.nextLong();
//            int target = in.nextInt();
            HashMap<Long, Integer> record = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Long num = nums[i];
                if (record.containsKey(target - num)) {
                    System.out.println("1 "+ (target - num) + " " + num);
                    return;
                } else {
                    record.put(num, i);
                }
            }
            System.out.println("0 0 0");
        }
        catch (Exception e){
            System.out.println("0 0 0");
        }
    }

}

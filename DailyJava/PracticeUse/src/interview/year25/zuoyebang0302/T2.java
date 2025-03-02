package interview.year25.zuoyebang0302;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String numsStr = in.nextLine();
            String[] strings = numsStr.split(",");
            int n = strings.length;
            int[] nums = new int[n];
            for(int i = 0; i < n; i ++){
                nums[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(nums);
            System.out.println(Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]));
        }
    }
}

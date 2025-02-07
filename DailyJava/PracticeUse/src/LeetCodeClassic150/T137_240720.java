package LeetCodeClassic150;

public class T137_240720 {

    class Solution {
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for(int num : nums){
                b = ~a & (b ^ num);
                a = ~b & (a ^ num);
            }
            return b;
        }
    }

}

package LeetCodeClassic150;

public class T69_240723 {

    class Solution1 {

        // 二分查找
        public int mySqrt(int x) {
            int left = 0, right = x;
            int res = 0;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if((long)mid * mid <= x){
                    res = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }

    class Solution {
        // 牛顿迭代
        public int mySqrt(int x) {
            if(x == 0){
                return 0;
            }
            double C = x, x0 = x;
            while(true){
                double xi = 0.5 * (x0 + C / x0);
                if(Math.abs(xi - x0) < 1e-7){
                    break;
                }
                x0 = xi;
            }
            return (int) x0;
        }
    }

}

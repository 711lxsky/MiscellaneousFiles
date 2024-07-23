package LeetCodeClassic150;

public class T50_240723 {

    class Solution1 {
        // 快速幂 + 递归
        public double myPow(double x, int n) {
            return n >= 0 ? quickMul(x,n) : 1.0 / quickMul(x, -n);
        }

        public double quickMul(double x, int n){
            if(n == 0){
                return 1.0;
            }
            double half = quickMul(x, n / 2);
            return n % 2 == 0 ? half * half : half * half * x;
        }
    }

    class Solution {
        // 迭代解法
        public double myPow(double x, int n) {
            long N = n;
            return n >= 0 ? myMul(x, N) : 1.0 / myMul(x, -N);
        }

        public double myMul(double x, long n){
            double coutribute = x, res = 1.0;
            while(n > 0){
                if(n % 2 != 0){
                    res *= coutribute;
                }
                coutribute *= coutribute;
                n /= 2;
            }
            return res;
        }
    }

}

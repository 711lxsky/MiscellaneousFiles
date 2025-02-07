package practice;

public class T165_240822 {

    // 用动规去解
    class Solution {
        public int crackNumber(int ciphertext) {
           int a = 1, b = 1;
           int x = 0, y = ciphertext % 10;
           while(ciphertext > 9){
               ciphertext /= 10;
               x = ciphertext % 10;
               int num = x * 10 + y;
               int c = num >= 10 && num <= 25 ? a + b : b;
               a = b;
               b = c;
               y = x;
           }
           return b;
        }
    }

}

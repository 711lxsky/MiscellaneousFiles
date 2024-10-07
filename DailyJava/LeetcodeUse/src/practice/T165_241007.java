package practice;

public class T165_241007 {

    class Solution {
        public int compareVersion(String version1, String version2) {
            // 根据 . 号进行分割
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            for(int i = 0; i < v1.length || i < v2.length; i ++){
                int num1 = i >= v1.length ? 0 : Integer.valueOf(v1[i]).intValue();
                int num2 = i >= v2.length ? 0 : Integer.valueOf(v2[i]).intValue();
                if(num1 - num2 > 0){
                    return 1;
                }else if (num1 - num2 < 0){
                    return -1;
                }
            }
            return 0;
        }
    }

}

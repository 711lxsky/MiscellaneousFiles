package practice;

public class T42_240831 {

    class Solution {
        public int trap(int[] height) {
            int res = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while(left < right){
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if(leftMax < rightMax){
                    res += leftMax - height[left];
                    left ++;
                }
                else {
                    res += rightMax - height[right];
                    right --;
                }
            }
            return res;
        }
    }

}

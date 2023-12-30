package LeetCodeClassic150;

import java.util.Stack;

/**
 * @author lxsky711
 * @date 2023-12-29 19:57
 */
public class P16_T42_231229 {

    class Solution1 {
        public int trap(int[] height) {
            // 维护一个单调递减的栈，顺序从左往右遍历height数组时，如果当前位置的高度高于栈顶元素，那么就是可以接到雨水的
            int n = height.length, ans = 0;
            Stack<Integer> monotonousStack = new Stack<>();
            for(int i = 0; i < n; i ++){
                int curHeight = height[i];
                while (! monotonousStack.empty() && curHeight > height[monotonousStack.peek()]){
                    int midHeight = height[monotonousStack.pop()];
                    if(monotonousStack.empty()){
                        break;
                    }
                    int preHeightIndex = monotonousStack.peek();
                    int preHeight = height[preHeightIndex];
                    ans += (Math.min(preHeight, curHeight) - midHeight) * (i - preHeightIndex);
                }
                monotonousStack.push(i);
            }
            return ans;
        }
    }

    class Solution {
        // 使用双指针的做法，实际上不用维护一个数组，只需要动态维护两个指针即可
        // 可以想到，如果在移动过程中，如果当前位置的左右两侧最大值都要比当前位置要高，那么就是呈现一个凹形，可以积水
        // 然后因为是动态维护的左右大值，所以更新之后的大值也只是在内部，与当前位置不冲突
        public int trap(int[] height) {
            int ans = 0, n = height.length;
            int leftIndex = 0, rightIndex = n - 1;
            int leftMax = 0, rightMax = 0;
            while (leftIndex < rightIndex){
                leftMax = Math.max(leftMax, height[leftIndex]);
                rightMax = Math.max(rightMax, height[rightIndex]);
                if(leftMax < rightMax) {
                    ans += leftMax - height[leftIndex];
                    leftIndex ++;
                }
                else {
                    ans += rightMax - height[rightIndex];
                    rightIndex --;
                }
            }
            return ans;
        }
    }
}

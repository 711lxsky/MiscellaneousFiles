package practice;

import java.util.Random;

public class T912_240829 {

    // 手撕随机快排
    // 实际上 可以理解为就是每次在数组中选取一个数作为基准值，然后将比它小的数都移到左边，大的移到右边
    // 然后对于基准值左侧的数据进行相同的操作

    class Solution {
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            randomQuickSort(nums, 0, n - 1);
            return nums;
        }

        // 随机快排
        public void randomQuickSort(int[] nums, int left, int right){
            if(left < right){
                // 将数组以基准值为边界分为两段，左侧都是比基准值要小的数，右边则大
                int index = randomPartition(nums, left, right);
                randomQuickSort(nums, left, index - 1);
                randomQuickSort(nums, index + 1, right);
            }
        }

        public int randomPartition(int[] nums, int left, int right){
            // 随机选取一个下标作为基准值
            int index = left + new Random().nextInt(right - left + 1);
            // 将基准值放到数组最右边
            swap(nums, index, right);
            return index;
        }

        public int partition(int[] nums, int left, int right){
            // 拿到基准值
            int standard = nums[right];
            // 小于区域的下标
            int lowIndex = left;
            for(int cur = left; cur < right; cur ++){
                // 小于等于基准值的数移动到左侧区域
                if(nums[cur] <= standard){
                    swap(nums, lowIndex++, cur);
                }
            }
            // 将基准值放到其对应位置
            swap(nums, lowIndex, right);
            return lowIndex;
        }

        public void swap(int[] nums, int index1, int index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

}

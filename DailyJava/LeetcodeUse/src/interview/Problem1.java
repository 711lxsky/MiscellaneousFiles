package interview;

public class Problem1 {

    public static void main(String[] args) {
        int n = 100;
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i ++){
            nums[i] = i % 3;
        }
        System.out.print( "initial : ");
        for(int num : nums){
            System.out.print( num + " ");
        }
        sort(nums);
        System.out.print( "\nsorted : ");
        for(int num : nums){
            System.out.print(num + "-");
        }
    }

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */

    public static void sort(int[] nums){
        // 相当于快排简单实现
        int index = 0, left = 0;
        int red = 0, white = 1, blue = 2;
        while (index < nums.length){
            if(nums[index] == red){
                swap(nums, left ++, index);
                // 红色移动
            }
            index ++;
        }
//        int right = nums.length - 1;
//        index = nums.length - 1;
//        while (index > left){
//            if(nums[index] == blue){
//                swap(nums, right --, index);
////                nums[right--] = nums[index];
//                // 白色
//            }
//            index --;
//        }
    }

    public static void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }


}

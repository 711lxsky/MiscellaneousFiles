package interview.year25.tencent0411;

public class T2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4,6,7,8};
        System.out.println(binarySearch(nums, -2));
    }

    public static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

package interview.year25.tencent0310;

public class HeepSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,3,1,4,2,2,4,2,8};
        heapSort(nums);
//        buildHeap(nums, nums.length);
        for(int num : nums){
            System.out.print(num + " - ");
        }
    }

    public static void heapSort(int[] nums){
        int n = nums.length;
        buildHeap(nums, n);
        for(int i = n - 1; i > 0; i --){
            swap(nums, 0 , i);
            heapify(nums, 0, i);
        }
    }

    public static void  buildHeap(int[] nums, int heapSize){
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i --){
            heapify(nums, i, heapSize);
        }
    }

    public static void heapify(int[] nums, int index, int heapSize){
        int largest = index, left = index * 2 + 1, right = index * 2 + 2;
        if(left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != index){
            swap(nums, largest, index);
            heapify(nums, largest, heapSize);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

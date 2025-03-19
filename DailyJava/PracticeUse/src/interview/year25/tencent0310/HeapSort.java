package interview.year25.tencent0310;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {3,2,4,2,1,6,3,7,6,3,4,9,1};
        heapSort(nums);
        for(int i = 0; i < nums.length; i ++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void heapSort(int[] nums){
        buildHeap(nums);
        for(int i = 0; i < nums.length; i ++){
            swap(nums, 0, nums.length - i - 1);
            heapify(nums, 0, nums.length - i - 1);
        }
    }

    public static void buildHeap(int[] nums){
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i --){
            heapify(nums, i, n);
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

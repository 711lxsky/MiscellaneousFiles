package MarscodeUse.数字分组求偶数和;

public class Main {

    public static int res = 0;
    public static int solution(int[] numbers) {
        // 回溯或者说深度优先遍历
        res = 0;
        backtrace(numbers, 0, 0);
        return res;
    }

    public static void backtrace(int[] nums, int preSum, int index){
        if(index == nums.length){
            if(preSum % 2 == 0){
                res += 1;
            }
            return;
        }
        int num = nums[index];
        String numStr = String.valueOf(num);
        for(int i = 0; i < numStr.length(); i ++){
            int add = numStr.charAt(i) - '0';
            backtrace(nums, preSum + add, index + 1);
        }
    }


    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }
}
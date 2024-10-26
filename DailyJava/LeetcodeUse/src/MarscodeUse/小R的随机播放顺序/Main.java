package MarscodeUse.小R的随机播放顺序;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static int[] solution(int n, int[] a) {
        // 使用队列即可，先全部入队
        Queue<Integer> queue = new ArrayDeque<>();
        for(int num : a){
            queue.add(num);
        }
        int[] res = new int[n];
        int index = 0;
        while(! queue.isEmpty()){
            // 取出队头
            Integer head = queue.poll();
            res[index++] = head;
            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(solution(5, new int[]{5, 3, 2, 1, 4}), new int[]{5, 2, 4, 1, 3}));
        System.out.println(Arrays.equals(solution(4, new int[]{4, 1, 3, 2}), new int[]{4, 3, 1, 2}));
        System.out.println(Arrays.equals(solution(6, new int[]{1, 2, 3, 4, 5, 6}), new int[]{1, 3, 5, 2, 6, 4}));
    }
}
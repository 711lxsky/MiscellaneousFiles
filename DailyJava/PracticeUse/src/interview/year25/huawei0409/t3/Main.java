package interview.year25.huawei0409.t3;

import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        List<int[]> targetOrder = generateOrder(N);
        Map<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                positionMap.put(matrix[i][j], new int[]{i, j});
            }
        }
        long operations = 0;
        for (int i = 0; i < N * N; i++) {
            int val = i + 1;
            int[] targetPos = targetOrder.get(i);
            int[] currentPos = positionMap.get(val);
            if (currentPos[0] == targetPos[0] && currentPos[1] == targetPos[1]) {
                continue;
            }
            positionMap.put(matrix[targetPos[0]][targetPos[1]], currentPos);
            matrix[currentPos[0]][currentPos[1]] = matrix[targetPos[0]][targetPos[1]];
            matrix[targetPos[0]][targetPos[1]] = val;
            operations++;
        }
        System.out.println(operations % MOD);
    }

    // 生成顺时针螺旋顺序的索引列表
    private static List<int[]> generateOrder(int N) {
        List<int[]> order = new ArrayList<>();
        int left = 0, right = N - 1, top = 0, bottom = N - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                order.add(new int[]{top, col});
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                order.add(new int[]{row, right});
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    order.add(new int[]{bottom, col});
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    order.add(new int[]{row, left});
                }
                left++;
            }
        }
        return order;
    }
}
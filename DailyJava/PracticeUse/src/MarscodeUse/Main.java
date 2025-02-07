package MarscodeUse;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(Arrays.toString(solution(1, 10, new int[][]{{1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 4}, {3, 2}, {4, 1}, {4, 2}, {5, 2}, {5, 3}})));
    }

    public static int[] solution(int id, int num, int[][] array) {
        // 我们只需要关注目标用户的游戏情况
        Set<Integer> game = new HashSet<>();
        for(int i = 0; i < num; i ++){
            if(array[i][0] == id){
                game.add(array[i][1]);
            }
        }
        Map<Integer, Integer> record = new HashMap<>();
        for(int[] person : array){
            if(game.contains(person[1])){
                record.put(person[0], record.getOrDefault(person[0], 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> kv : record.entrySet()){
            if(kv.getKey() != id && kv.getValue() >= 2){
                res.add(kv.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

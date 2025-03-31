package interview.year25.honor0331;

import java.util.HashMap;
import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] split = str.split(",");
            String targetKey = split[0];
            Integer time = Integer.valueOf(split[1]);
            if (map.containsKey(targetKey)) {
                map.put(targetKey, map.get(targetKey) + time);
            } else {
                map.put(targetKey, time);
            }
        }
        int res = 0;
        for(String key : map.keySet()){
            if(map.get(key) >= 10){
                res ++;
            }
        }
        System.out.println(res);
    }

}

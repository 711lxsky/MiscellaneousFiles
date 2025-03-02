package interview.year25.zuoyebang0302;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T1 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String get = in.nextLine();
            String[] urlAndKey = get.split(" ");
            String url = urlAndKey[0];
            String targetKey = urlAndKey[1];
            int i = url.indexOf('?');
//            String[] split = url.split("//?");
            String keyValues = url.substring(i + 1);
            String[] splits = keyValues.split("&");
            Map<String, String> record = new HashMap<>();
            int n = splits.length;
            for(String s : splits){
                String[] sp = s.split("=");
                record.put(sp[0], sp[1]);

            }
            System.out.println(record.get(targetKey));
        }
    }

}

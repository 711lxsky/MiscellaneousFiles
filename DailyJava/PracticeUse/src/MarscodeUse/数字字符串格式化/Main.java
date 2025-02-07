package MarscodeUse.数字字符串格式化;

public class Main {
    public static String solution(String s) {
        // 去掉开头的0字符 + 小数点分割 + 添加,
        String[] splits = s.split("\\.");
        StringBuilder integer = new StringBuilder(splits[0]);
        // 去0
        StringBuilder intRemoveZero = new StringBuilder();
        boolean firstZero = false;
        for(int i = 0; i < integer.length(); i ++){
            if(integer.charAt(i) != '0' || (firstZero && integer.charAt(i) == '0')){
                intRemoveZero.append(integer.charAt(i));
                firstZero = true;
            }
        }
        if(intRemoveZero.length() == 0){
            intRemoveZero = new StringBuilder("0");
        }
        integer = new StringBuilder();
        int cnt = 1;
        for(int i = intRemoveZero.length() - 1; i >= 0; i --, cnt ++){
            integer.append(intRemoveZero.charAt(i));
            if(cnt % 3 == 0 && i != 0){
                integer.append(",");
            }
        }
        return integer.reverse() + (splits.length == 2 ? "." + splits[1] : "");

    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}

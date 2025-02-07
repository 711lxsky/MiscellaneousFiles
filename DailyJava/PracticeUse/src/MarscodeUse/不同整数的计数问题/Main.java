package MarscodeUse.不同整数的计数问题;

import java.util.HashSet;
import java.util.Set;

class Main {
    public static int solution(String word) {
        // 先把非数字字符替换
        StringBuilder sb = new StringBuilder();
        char lastCh = ' ';
        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9'){
                sb.append(ch);
                lastCh = ch;
            }
            else {
                if(lastCh != ' '){
                    sb.append(" ");
                }
                lastCh = ' ';
            }
        }
        // 分割
        String[] split = sb.toString().split(" ");
        Set<Integer> set = new HashSet<>();
        for(String s : split){
            if(s != null && !s.isEmpty()){
                set.add(Integer.valueOf(s));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("m") == 0);
        System.out.println(solution("a123bc34d8ef34") == 3);
        System.out.println(solution("t1234c23456") == 2);
        System.out.println(solution("a1b01c001d4") == 2);
    }
}
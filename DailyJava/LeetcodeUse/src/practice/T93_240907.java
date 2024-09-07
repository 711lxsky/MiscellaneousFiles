package practice;

import java.util.ArrayList;
import java.util.List;

public class T93_240907 {

    class Solution {

        List<String> res = new ArrayList<>();
        int ipCount = 4;
        int[] ipNums = new int[ipCount];
        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 0);
            return res;
        }

        public void dfs(String s, int ipSeq, int index){
            if(ipSeq == ipCount){
                if(index == s.length()){
                    StringBuilder sb = new StringBuilder();
                    for(int ipNum : ipNums){
                        sb.append(ipNum).append(".");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    res.add(sb.toString());
                    return;
                }else {
                    return;
                }
            }
            if(index == s.length()){
                return;
            }
            if(s.charAt(index) == '0'){
                ipNums[ipSeq] = 0;
                dfs(s, ipSeq + 1, index + 1);
            }
            else {
                int ipNum = ipNums[ipSeq];
                for(int i = index; i < s.length(); i ++){
                    ipNum = ipNum * 10 + s.charAt(i) - '0';
                    if(ipNum >= 0 && ipNum <= 255){
                        ipNums[ipSeq] = ipNum;
                        dfs(s, ipSeq + 1, i + 1);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

}

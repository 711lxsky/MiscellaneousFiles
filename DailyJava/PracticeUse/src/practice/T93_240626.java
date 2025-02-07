package practice;

import java.util.ArrayList;
import java.util.List;

public class T93_240626 {

    static class Solution {

        int seqNum = 4;
        List<String> res = new ArrayList<>();
        int [] seqs = new int[seqNum];

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 0);
            return res;
        }

        public void dfs(String s, int seqIndex, int addressIndex){
            if(seqIndex == seqNum){
                if(addressIndex == s.length()){
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < seqNum; i ++){
                        sb.append(seqs[i]);
                        if(i != seqNum - 1){
                            sb.append('.');
                        }
                    }
                    res.add(sb.toString());
                }
                return;
            }
            if(addressIndex == s.length()){
                return;
            }
            if(s.charAt(addressIndex) == '0'){
                seqs[seqIndex] = 0;
                dfs(s, seqIndex + 1, addressIndex + 1);
            }
            else {
                int curIp = 0;
                for(int i = addressIndex; i < s.length(); i ++){
                    curIp *= 10;
                    curIp += s.charAt(i) - '0';
                    if(curIp > 0 && curIp <= 0xff){
                        seqs[seqIndex] = curIp;
                        dfs(s, seqIndex + 1, i + 1);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        T93_240626 t = new T93_240626();
        T93_240626.Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

}

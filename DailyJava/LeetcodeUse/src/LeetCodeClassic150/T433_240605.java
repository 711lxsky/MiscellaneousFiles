package LeetCodeClassic150;

import java.util.*;

public class T433_240605 {

    class Solution {

        // 基因种类
        private static final char[] gene = new char[]{'A', 'C', 'G', 'T'};

        public int minMutation(String startGene, String endGene, String[] bank) {
            // 判断是否已经存在这个变换
            Set<String> exit = new HashSet<>();
            Queue<String> myQue = new LinkedList<>();
            if(startGene.equals(endGene)){
                return 0;
            }
            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            if(!bankSet.contains(endGene)){
                return -1;
            }
            myQue.offer(startGene);
            exit.add(startGene);
            int step = 1;
            while(!myQue.isEmpty()){
                int curSize = myQue.size();
                // 对当前所有的存在的序列做变换，只变换一个位置
                for(int i = 0; i < curSize; i ++){
                    String cur = myQue.poll();
                    for(int pos = 0; pos < 8; pos ++){
                       for(char g : gene){
                           if(cur.charAt(pos) != g){ // 去掉本身
                               StringBuilder sb = new StringBuilder(cur);
                               sb.setCharAt(pos, g);
                               // 只有不是已生成和在bank中的才是合法序列
                               if(! exit.contains(sb.toString()) && bankSet.contains(sb.toString())){
                                   if(sb.toString().equals(endGene)){
                                       return step;
                                   }
                                   exit.add(sb.toString());
                                   myQue.offer(sb.toString());
                               }
                           }
                       }
                    }
                }
                step ++;
            }
            return -1;
        }
    }

}

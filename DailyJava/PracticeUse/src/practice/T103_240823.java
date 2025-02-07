package practice;

import java.util.*;

public class T103_240823 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null){
                return res;
            }
            Deque<TreeNode> myQue = new ArrayDeque<>();
            myQue.push(root);
            int flag = 0;
            while(! myQue.isEmpty()){
                int size = myQue.size();
                List<Integer> curList = new ArrayList<>();
                for(int i = 0; i < size; i ++){
                    TreeNode cur = myQue.poll();
                    curList.add(cur.val);
                    if(cur.left != null){
                        myQue.add(cur.left);
                    }
                    if(cur.right != null){
                        myQue.add(cur.right);
                    }
                }
                if(flag % 2 != 0){
                   Collections.reverse(curList);
                }
                res.add(curList);
                flag ++;
            }
            return res;
        }
    }

}

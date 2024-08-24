package practice;

import java.util.*;

public class T103_240824 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 先来非递归 广度优先遍历
    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Deque<TreeNode> myQue = new ArrayDeque<>();
            myQue.add(root);
            boolean leftFlag = true;
            while(! myQue.isEmpty()){
                int size = myQue.size();
                List<Integer> curList = new ArrayList<>();
                for(int i = 0; i < size; i ++){
                    if(leftFlag){
                        TreeNode cur = myQue.pollFirst();
                        curList.add(cur.val);
                        if(cur.left != null){
                            myQue.addLast(cur.left);
                        }
                        if(cur.right != null){
                            myQue.addLast(cur.right);
                        }
                    }
                    else {
                        TreeNode cur = myQue.pollLast();
                        curList.add(cur.val);
                        if(cur.right != null){
                            myQue.addFirst(cur.right);
                        }
                        if(cur.left != null){
                            myQue.addFirst(cur.left);
                        }
                    }
                }
                leftFlag = ! leftFlag;
                res.add(curList);
            }
            return res;
        }
    }

    // 递归解法， 深度优先遍历
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            zTravel(root, res, 0);
            return res;
        }

        public void zTravel(TreeNode cur, List<List<Integer>> res, int level){
            if(cur == null){
                return;
            }
            if(res.size() <= level){
                res.add(new LinkedList<>());
            }
            if(level % 2 == 0){
                res.get(level).add(cur.val);
            }
            else {
                res.get(level).add(0, cur.val);
            }
            zTravel(cur.left, res, level + 1);
            zTravel(cur.right, res, level + 1);
        }
    }

}

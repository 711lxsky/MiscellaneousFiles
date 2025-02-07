package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T102_240812 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> record = new ArrayDeque<>();
            record.add(root);
            while(! record.isEmpty()){
                int curSize = record.size();
                List<Integer> curList = new ArrayList<>();
                for(int i = 0; i < curSize; i ++){
                    TreeNode cur = record.poll();
                    if(cur.left != null){
                        record.add(cur.left);
                    }
                    if(cur.right != null){
                        record.add(cur.right);
                    }
                    curList.add(cur.val);
                }
                res.add(curList);
            }
            return res;
        }
    }

}

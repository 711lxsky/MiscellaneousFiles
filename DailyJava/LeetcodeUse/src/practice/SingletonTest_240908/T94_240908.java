package practice.SingletonTest_240908;

import java.util.*;

public class T94_240908 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // 非递归实现
    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Stack<TreeNode> myStack = new Stack<>();
            while(root != null || ! myStack.isEmpty()){
                while(root != null){
                    myStack.push(root);
                    root = root.left;
                }
                root = myStack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }

}

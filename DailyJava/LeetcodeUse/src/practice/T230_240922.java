package practice;

import java.util.Stack;

public class T230_240922 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
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
        public int kthSmallest(TreeNode root, int k) {
            // 使用中序遍历进行寻找
            Stack<TreeNode> myStack = new Stack<>();
            while(true){
                while(root != null){
                    myStack.push(root);
                    root = root.left;
                }
                root = myStack.pop();
                k --;
                if(k == 0){
                    return root.val;
                }
                root = root.right;
            }
//            return -1;
        }
    }

}

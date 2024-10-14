package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T105_241013 {

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

    class Solution1 {

        Map<Integer, Integer> treeInorderMap;
        int[] preorder;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 递归构建
            int n = inorder.length;
            this.treeInorderMap = new HashMap<>();
            this.preorder = preorder;
            for(int i = 0; i < n; i ++){
                treeInorderMap.put(inorder[i], i);
            }
            return build(0, 0, inorder.length - 1);
        }

        public TreeNode build(int rootPreorderIndex, int left, int right){
            if(left > right){
                return null;
            }
            TreeNode root = new TreeNode(preorder[rootPreorderIndex]);
            int rootInorderIndex = treeInorderMap.get(preorder[rootPreorderIndex]);
            root.left = build(rootPreorderIndex + 1, left, rootInorderIndex - 1);
            root.right = build(rootPreorderIndex + 1 + rootInorderIndex - left, rootInorderIndex + 1, right);
            return root;
        }

    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 使用迭代的方式进行构建
            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int inorderIndex = 0;
            for(int i = 1; i < inorder.length; i ++){
                TreeNode topNode = stack.peek();
                if(topNode.val != inorder[inorderIndex]){
                    TreeNode newNode = new TreeNode(preorder[i]);
                    topNode.left = newNode;
                    stack.push(newNode);
                }else {
                    while(! stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                        topNode = stack.pop();
                        inorderIndex ++;
                    }
                    topNode.right = new TreeNode(preorder[i]);
                    stack.push(topNode.right);
                }
            }
            return root;
        }
    }

}

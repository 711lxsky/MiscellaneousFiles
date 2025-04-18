package interview.year25.tencent0416;

import java.util.ArrayDeque;
import java.util.Queue;

public class t1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        node3.right = node6;
        printOrder(node1);
    }

    public static void printOrder(TreeNode root){
        Queue<TreeNode> myQue = new ArrayDeque<>();
        myQue.add(root);
        while(! myQue.isEmpty()){
            int size = myQue.size();
            for(int i = 0; i < size; i ++){
                TreeNode first = myQue.poll();
                String print = "";
                if(first.val == -1){
                    print = "*";
                }else {
                    print = String.valueOf(first.val);
                    myQue.offer(first.left == null ? new TreeNode(-1): first.left);
                    myQue.offer(first.right == null ? new TreeNode(-1) : first.right);
                }
                System.out.print(print + " ");
            }
            System.out.println();
        }
    }

}

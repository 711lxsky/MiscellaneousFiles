package interview.year25.tencent0414;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        node2.right = node5;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.right = node4;
        node1.left = node2;
        node1.right = node3;
        List<Integer> order = getOrder(node1);
        for(Integer num : order){
            System.out.print(num + " ");
        }
    }

    public static List<Integer> getOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> myQue = new ArrayDeque<>();
//        res.add(root.val);
        myQue.add(root);
        while(! myQue.isEmpty()){
            int size = myQue.size();
            for(int i = 0; i < size; i ++){
                TreeNode cur = myQue.poll();
                if(cur.left != null){
                    myQue.add(cur.left);
                }
                if(cur.right != null){
                    myQue.add(cur.right);
                }
                if(i == size - 1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }



}

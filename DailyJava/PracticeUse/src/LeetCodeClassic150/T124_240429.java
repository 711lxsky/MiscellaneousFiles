package LeetCodeClassic150;

/**
 * @Author: 711lxsky
 * @Description:
 */

public class T124_240429 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {

         int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getContribute(root);
            return maxPath;
        }

        // 求取贡献值
        public int getContribute(TreeNode cur){
            if(cur == null){
                return 0;
            }
            // 拿到左子节点和右子节点的路径和
            int leftPath = Math.max(getContribute(cur.left), 0);
            int rightPath = Math.max(getContribute(cur.right), 0);
            // 更新最大路径和
            int curPathSum = cur.val + leftPath + rightPath;
            maxPath = Math.max(maxPath, curPathSum);
            // 注意贡献值是当前节点值 + 单边子节点路径和
            return cur.val + Math.max(leftPath, rightPath);
        }
    }

}

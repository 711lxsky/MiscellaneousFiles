package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T236_240820 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // 非递归写法
    class Solution1 {

        Map<Integer, TreeNode> record = new HashMap<>();
        Set<TreeNode> visit = new HashSet<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            while(q != null){
                visit.add(q);
                q = record.get(q.val);
            }
            while (p != null){
                if(visit.contains(p)){
                    return p;
                }
                p = record.get(p.val);
            }
            return null;
        }

        public void dfs(TreeNode root){
            if(root.left != null){
                record.put(root.left.val, root);
                dfs(root.left);
            }
            if(root.right != null){
                record.put(root.right.val, root);
                dfs(root.right);
            }
        }
    }

    // 递归写法
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            if(root.val == q.val || root.val == p.val){
                return root;
            }
            TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
            TreeNode rightFind = lowestCommonAncestor(root.right, p, q);
            if(leftFind != null && rightFind != null){
                return root;
            }
            if(leftFind != null){
                return root.left;
            }
            return root.right;
        }
    }


}

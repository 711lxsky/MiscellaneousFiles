package LeetCodeClassic150;

public class T108_240622 {


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
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0 , nums.length);
        }

        public TreeNode buildBST(int[] nums, int left, int right){
            if(right < left || left == nums.length){
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode curNode = new TreeNode(nums[mid]);
            curNode.left = buildBST(nums, left, mid - 1);
            curNode.right = buildBST(nums, mid + 1, right);
            return curNode;
        }
    }

}

from pyparsing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], target_sum: int) -> bool:
        if root == None:
            return False
        if self.isLeaf(root):
            return target_sum == root.val
        return self.hasPathSum(root.left, target_sum - root.val) or self.hasPathSum(root.right, targetSum - root.val)
        
    def isLeaf(self, node):
        return node.left == None and node.right == None
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root, float('-inf'), float('inf'))
    
    def dfs(self, root: Optional[TreeNode], lower: int, upper: int) -> bool:
        if root is None:
            return True
        if root.val <= lower or root.val >= upper:
            return False
        return self.dfs(root.left, lower, root.val) and self.dfs(root.right, root.val, upper)
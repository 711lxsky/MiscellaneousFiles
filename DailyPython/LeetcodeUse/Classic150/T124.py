from pyparsing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:

    def __init__(self) -> None:
        self.max_sum = float('-inf')

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        def getMaxPath(cur):
            if not cur:
                return 0
            left_path = max(getMaxPath(cur.left), 0)
            right_path = max(getMaxPath(cur.right), 0)
            path_sum = cur.val + left_path + right_path
            self.max_sum = max(self.max_sum, path_sum)
            return cur.val + max(left_path, right_path)
        getMaxPath(root)
        return self.max_sum


    

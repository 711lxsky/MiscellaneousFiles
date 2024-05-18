from pyparsing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

        
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if root is None:
            return res
        tree_record = [root]
        while tree_record:
            res.append(tree_record[-1].val)
            temp = []
            for node in tree_record:
                if node.left:
                    temp.append(node.left)
                if node.right:
                    temp.append(node.right)
            tree_record = temp
        return res
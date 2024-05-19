from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root :
            return []
        cur_tree_record = [root]
        res = []
        while cur_tree_record:
            res.append([node.val for node in cur_tree_record])
            next_record = []
            for node in cur_tree_record:
                if node.left:
                    next_record.append(node.left)
                if node.right:
                    next_record.append(node.right)
            cur_tree_record = next_record
        return res

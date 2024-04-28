from pyparsing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return None
        my_stack = [root]
        prev = None
        while my_stack:
            cur = my_stack.pop()
            if prev:
                prev.right = cur
            if cur.right:
                my_stack.append(cur.right)
            if cur.left:
                my_stack.append(cur.left)
            cur.left = cur.right = None
            prev = cur
        
            

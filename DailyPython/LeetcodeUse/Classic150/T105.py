
from inspect import stack
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        n = len(preorder)
        if n == 0:
            return None
        my_stack = []
        root = TreeNode(preorder[0])
        my_stack.append(root)
        inorder_index = 0
        for i in range(1, n):
            preorder_val, node  = preorder[i], my_stack[-1]
            if node.val != inorder[inorder_index]:
                node.left = TreeNode(preorder_val)
                my_stack.append(node.left)
            else:
                while my_stack and my_stack[-1].val == inorder[inorder_index]:
                    node = my_stack.pop()
                    inorder_index += 1
                node.right = TreeNode(preorder_val)
                my_stack.append(node.right)
        return root
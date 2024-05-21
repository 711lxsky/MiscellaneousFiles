from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        tree_record = []
        while root or tree_record:
            while root:
                tree_record.append(root)
                root = root.left
            root = tree_record.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution1:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in (None, p, q):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        return None
    
class Solution:

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        record = {}
        visit = {}
        def dfs(cur: TreeNode):
            if cur.left :
                record[cur.left.val] = cur
                dfs(cur.left)
            if cur.right:
                record[cur.right.val] = cur
                dfs(cur.right)
        record[root.val] = None
        dfs(root)
        while p:
            visit[p.val] = True
            p = record[p.val]
        while q:
            if q.val in visit:
                return q
            q = record[q.val]
        return None


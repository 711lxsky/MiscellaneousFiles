from collections import deque


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return None
        node_record = deque()
        root.next = None
        node_record.append(root)
        while node_record:
            cur_size = len(node_record)
            prev_node = None
            for _ in range(0, cur_size):
                cur_node = node_record.popleft()
                if cur_node.left != None:
                    node_record.append(cur_node.left)
                if cur_node.right != None:
                    node_record.append(cur_node.right)
                if prev_node:
                    prev_node.next = cur_node
                prev_node = cur_node
        return root   

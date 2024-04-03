from pyparsing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        cur = head
        while cur :
            newNode = Node(cur.val, None, None)
            curNext = cur.next 
            cur.next = newNode
            newNode.next = curNext
            cur = curNext
        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next
        res = head.next 
        cur = head
        while cur :
            tmp = cur.next
            if tmp:
                cur.next = cur.next.next
            cur = tmp
        return res
    

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        myMap = dict()
        ptr = head
        while ptr:
            newNode = Node(ptr.val, None, None)
            myMap[ptr] = newNode
            ptr = ptr.next
        ptr = head
        while ptr:
            if ptr.next:
                myMap[ptr].next = myMap[ptr.next]
            if ptr.random:
                myMap[ptr].random = myMap[ptr.random]
            ptr = ptr.next
        return myMap[head]
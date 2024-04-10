from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

        
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head == None or head.next == None or k == 0:
            return head
        dummy = ListNode(-1, head)
        tail = dummy
        n = 0
        while tail.next :
            tail = tail.next
            n += 1
        cur = dummy
        k %= n
        n -= k
        while n > 0 :
            cur = cur.next
            n -= 1
        if cur.next == None :
            return head
        _next = cur.next
        cur.next = None
        tail.next = head
        dummy.next = _next
        return dummy.next

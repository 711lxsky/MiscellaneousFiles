class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from pyparsing import Optional

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        pre = dummy
        while head:
            tail = pre
            for i in range(k):
                tail = tail.next
                if not tail:
                    return dummy.next
            next = tail.next
            head, tail = self.reverse(head, tail)
            pre.next = head
            tail.next = next
            pre = tail
            head = tail.next
        return dummy.next

    def reverse(self, head: ListNode, tail: ListNode):
        pre = tail.next
        cur = head
        while pre != tail:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return tail, head
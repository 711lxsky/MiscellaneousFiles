from pyparsing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        cnt = 0
        ptr = head
        while ptr :
            cnt += 1
            ptr = ptr.next
        cur = dummy
        cnt -= n
        while cnt > 0 :
            cnt -= 1
            cur = cur.next
        next = cur.next.next
        cur.next = next
        return dummy.next
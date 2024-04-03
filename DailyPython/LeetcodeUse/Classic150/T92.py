from pyparsing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        # 设置 dummyNode 是这一类问题的一般做法
        dummy_node = ListNode(-1)
        dummy_node.next = head
        pre = dummy_node
        for _ in range(left - 1):
            pre = pre.next

        cur = pre.next
        for _ in range(right - left):
            next = cur.next
            cur.next = next.next
            next.next = pre.next
            pre.next = next
        return dummy_node.next
    

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        pre = dummy
        for _ in range(left - 1):
            pre = pre.next
        cur = pre.next
        tmp1 = pre
        tmp2 = cur
        for _ in range(right - left + 1):
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        tmp1.next = pre
        tmp2.next = cur
        return dummy.next
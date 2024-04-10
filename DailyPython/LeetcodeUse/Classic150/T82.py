from pyparsing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

        
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None :
            return head
        dummy = ListNode(-1, head)
        cur = dummy
        _next = dummy.next
        while _next :
            if _next.next == None :
                break
            if _next.val == _next.next.val:
                while _next.next and _next.val == _next.next.val:
                    _next = _next.next
                #  注意这个地方，因为需要把这个元素删掉的关系，还要往下走一步
                _next = _next.next
                cur.next = _next
            else :
                _next = _next.next
                cur = cur.next
        return dummy.next

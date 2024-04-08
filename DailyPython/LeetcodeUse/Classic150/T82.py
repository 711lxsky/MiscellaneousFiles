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
        next = dummy.next
        while next :
            if next.next == None :
                break
            if next.val == next.next.val:
                while next.next and next.val == next.next.val:
                    next = next.next
                #  注意这个地方，因为需要把这个元素删掉的关系，还要往下走一步
                next = next.next
                cur.next = next
            else :
                next = next.next
                cur = cur.next
        return dummy.next

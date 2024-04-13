from pyparsing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        # 分别定位第一个小于、大于目标数的位置, 其实也不需要
        small_dummy = ListNode(-1, None)
        large_dummy = ListNode(-1, None)
        # min_ptr = head
        # while min_ptr != None and min_ptr.val >= x:
        #     min_ptr = min_ptr.next
        # if min_ptr == None:
        #     return head
        # small_dummy.next = min_ptr
        # max_ptr = head
        # while max_ptr != None and max_ptr.val < x:
        #     max_ptr = max_ptr.next
        # if max_ptr == None:
        #     return head
        # large_dummy.next = max_ptr
        # 开始分割
        min_ptr = small_dummy
        max_ptr = large_dummy
        ptr = head
        while ptr != None:
            if ptr.val < x:
                min_ptr.next = ptr
                min_ptr = min_ptr.next
            else :
                max_ptr.next = ptr
                max_ptr = max_ptr.next
            ptr = ptr.next
        # 合并
        min_ptr.next = large_dummy.next
        max_ptr.next = None
        return small_dummy.next

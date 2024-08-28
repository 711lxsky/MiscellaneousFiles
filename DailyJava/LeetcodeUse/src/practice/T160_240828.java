package practice;

public class T160_240828 {

    class ListNode {
        int val;
        ListNode next;
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 在两个指针其中之一走到末尾时切到另一个链表
            if(headA == null || headB == null){
                return null;
            }
            ListNode ptr1 = headA, ptr2 = headB;
            while(ptr1 != ptr2){
                ptr1 = ptr1 == null ? headB : ptr1.next;
                ptr2 = ptr2 == null ? headA : ptr2.next;
            }
            return ptr1;
        }
    }

}

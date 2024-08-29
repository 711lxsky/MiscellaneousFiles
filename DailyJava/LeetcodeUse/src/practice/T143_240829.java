package practice;

public class T143_240829 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            // 比较好玩儿的一道题 一般感觉就是 先后半翻转 -> 合并两个链表
            // 先快慢指针到中部分割
            if(head == null || head.next == null){
                return;
            }
            ListNode ptr1 = head, ptr2 = head;
            while(ptr2 != null && ptr2.next != null){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next.next;
            }
            ListNode prev = null;
            ListNode cur = ptr1.next;
            ptr1.next = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ptr1 = head;
            ptr2 = prev;
            while(ptr2 != null){
                ListNode next1 = ptr1.next;
                ptr1.next = ptr2;
                ListNode next2 = ptr2.next;
                ptr2.next = next1;
                ptr1 = next1;
                ptr2 = next2;
            }
        }
    }

}

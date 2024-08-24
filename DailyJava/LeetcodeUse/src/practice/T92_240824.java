package practice;

public class T92_240824 {

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

    // 普通的一次遍历
    class Solution1 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy, cur = head;
            for(int i = 1; i < left; i ++){
                pre = pre.next;
                cur = cur.next;
            }
            ListNode start = pre;
            for(int i = left; i <= right; i ++){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            start.next.next = cur;
            start.next = pre;
            return dummy.next;
        }
    }

    // 穿针引线
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode mark = dummy, cur = head;
            for(int i = 1; i < left; i ++){
                mark = mark.next;
                cur = cur.next;
            }
            for(int i = 0; i < right - left; i ++){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = mark.next;
                mark.next = next;
            }
            return dummy.next;
        }
    }

}

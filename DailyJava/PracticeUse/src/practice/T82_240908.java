package practice;

public class T82_240908 {

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
        public ListNode deleteDuplicates(ListNode head) {
            // 直接指到最后一个非重复元素
            if(head == null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
            ListNode cur = dummy;
            while(cur.next != null && cur.next.next != null){
                if(cur.next.val == cur.next.next.val){
                    int x = cur.next.val;
                    while(cur.next != null && x == cur.next.val ){
                        cur.next = cur.next.next;
                    }
                }
                else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }

}

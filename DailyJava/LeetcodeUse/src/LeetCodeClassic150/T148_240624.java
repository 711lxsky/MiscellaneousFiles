package LeetCodeClassic150;

public class T148_240624 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    class Solution {
        public ListNode sortList(ListNode head) {
            return selfMergeSort(head, null);
        }

        public ListNode selfMergeSort(ListNode head, ListNode tail){
            if(head == null){
                return null;
            }
            if(head.next == tail){
                head.next = null;
                return head;
            }
            ListNode fast = head, slow = head;
            while(fast != tail){
                fast = fast.next;
                slow = slow.next;
                if(fast.next != tail){
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            return mergeList(selfMergeSort(fast, mid), selfMergeSort(mid, slow));
        }

        public ListNode mergeList(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1, null);
            ListNode ptr = dummy;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    ptr.next = l1;
                    l1 = l1.next;
                }else {
                    ptr.next = l2;
                    l2 = l2.next;
                }
                ptr = ptr.next;
            }
            if(l1 != null){
                ptr.next = l1;
            }
            if(l2 != null){
                ptr.next = l2;
            }
            return dummy.next;
        }
    }

}

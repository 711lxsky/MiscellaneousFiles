package practice;

public class T25_240810 {

    class ListNode {
        public int val;
        public ListNode next;

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
        public ListNode reverseKGroup(ListNode head, int k) {
            return reverseK(head, k);
        }

        // 按段递归来做
        public ListNode reverseK(ListNode curHead, int k){
            ListNode ptr = curHead;
            int size = 0;
            while(ptr != null && size < k){
                ptr = ptr.next;
                size ++;
            }
            if(size != k){
                return curHead;
            }
            ListNode prev = null;
            ListNode curr = curHead;
            while(curr != ptr){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            curHead.next = reverseK(curr, k);
            return prev;
        }
    }

}

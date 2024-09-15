package practice;

public class T148_240914 {

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

    // 先进行自顶向下的归并排序
    class Solution1 {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            // 先快慢指针拿到中间点
            ListNode fast = head.next, slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(head2);
            return merge(l1, l2);
        }
    }

    // 使用自下向上的归并排序
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            // 获取到链表的长度
            int len = 0;
            ListNode ptr = head;
            while(ptr != null){
                ptr = ptr.next;
                len ++;
            }
            ListNode dummy = new ListNode(-1, head);
            for(int curLen = 1; curLen < len; curLen *= 2){
                // 每次重新执行到链表头
                ListNode prev = dummy;
                ListNode curr = dummy.next;
                // 每次一个while循环就是一次 curLen的 归并
                while(curr != null){
                    ListNode head1 = curr;
                    for(int i = 1; i < curLen && curr.next != null; i ++){
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for(int i = 1; i< curLen && curr != null && curr.next != null; i ++){
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if(curr != null){
                        next = curr.next;
                        curr.next = null;
                    }
                    prev.next = merge(head1, head2);
                    while(prev.next != null){
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummy.next;
        }
    }


    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }


}

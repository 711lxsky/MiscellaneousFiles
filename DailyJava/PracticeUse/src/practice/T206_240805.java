package practice;

public class T206_240805 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(){};

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head){
            ListNode cur = head;
            ListNode pre = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    /**
     * 模拟面试
     */
    public static void main(String[] args) {
        int n = 50;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i = 0; i < n; i ++){
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
        cur = dummy.next;
        while(cur != null){
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        Solution solution = new Solution();
        cur = solution.reverseList(dummy.next);
        System.out.print("null\n\n");
        while(cur != null){
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        System.out.print("null\n");
    }

}

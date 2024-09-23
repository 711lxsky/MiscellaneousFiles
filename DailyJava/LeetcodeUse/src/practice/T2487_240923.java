package practice;

import java.util.Stack;

public class T2487_240923 {

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

        public ListNode removeNodes(ListNode head) {
            // 思路就是使用一个栈将元素依次压入，从刚开始逐次选出一个最大节点
            if(head == null || head.next == null){
                return head;
            }
            Stack<ListNode> myStack = new Stack<>();
            ListNode ptr = head;
            while(ptr != null){
                myStack.push(ptr);
                ptr = ptr.next;
            }
            int max = Integer.MIN_VALUE;
            ListNode dummy = new ListNode(-1, null);
            while(! myStack.isEmpty()){
                ListNode cur = myStack.pop();
                if(cur.val >= max){
                    max = cur.val;
                    cur.next = dummy.next;
                    dummy.next = cur;
                }
            }
            return dummy.next;
        }
    }

}

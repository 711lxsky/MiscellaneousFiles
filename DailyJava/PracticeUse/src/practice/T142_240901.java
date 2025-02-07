package practice;

import java.util.HashSet;
import java.util.Set;

public class T142_240901 {

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

    // 常规 用集合
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> record = new HashSet<>();
            ListNode ptr = head;
            while (ptr != null){
                if(record.contains(ptr)){
                    return ptr;
                }
                record.add(ptr);
                ptr = ptr.next;
            }
            return null;
        }
    }

    // 快慢指针解法
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    // 已知有环
                    ListNode ptr = head;
                    while(ptr != slow){
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }

}

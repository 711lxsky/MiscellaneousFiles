package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T23_240825 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    // 最朴素的做法
    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode tmp = new ListNode(Integer.MIN_VALUE);
            for(ListNode list : lists){
                tmp = merge(tmp, list);
            }
            return tmp.next;
        }

        public ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if(l1 != null){
                cur.next = l1;
            }
            if(l2 != null){
                cur.next = l2;
            }
            return dummy.next;
        }
    }

    // 分治合并
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int left, int right){
            if(left == right){
                return lists[left];
            }
            if(left > right){
                return null;
            }
            int mid = (left + right) >> 1;
            return internalMerge(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        public ListNode internalMerge(ListNode l1, ListNode l2){
            if(l1 == null || l2 == null){
                return l1 != null ? l1 : l2;
            }
            ListNode dummy = new ListNode(-1);
            ListNode ptr =dummy;
            while (l1 != null && l2 != null){
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

    // 最优雅的优先级队列
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> record = new PriorityQueue<>(
                    Comparator.comparingInt(l -> l.val)
            );
            for(ListNode listNode : lists){
                if(listNode != null){
                    record.offer(listNode);
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (! record.isEmpty()){
                cur.next = record.poll();
                cur = cur.next;
                if(cur.next != null){
                    record.offer(cur.next);
                }
            }
            return dummy.next;
        }
    }

}

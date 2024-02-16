package LeetCode_Hot100;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: 711lxsky
 * @Date: 2024-02-01
 */

public class T23_240201 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            // 除了朴素解法，还可以像二分法那样分而治之
            return mergeListForLeftAndRight(lists, 0, lists.length - 1);
        }

        public ListNode mergeListForLeftAndRight(ListNode[] lists, int left, int right){
            if(left == right){
                return lists[right];
            }
            if(left > right){
                return null;
            }
            int mid = left + (right - left) / 2;
            return mergeTwoList(mergeListForLeftAndRight(lists, left, mid), mergeListForLeftAndRight(lists, mid + 1, right));
        }

        public ListNode mergeTwoList(ListNode index1, ListNode index2){
            ListNode dummy = new ListNode();
            ListNode ptr = dummy;
            while( index1 != null && index2 != null){
                if(index1.val < index2.val){
                    ptr.next = index1;
                    index1 = index1.next;
                }
                else {
                    ptr.next = index2;
                    index2 = index2.next;
                }
                ptr = ptr.next;
            }
            if(index1 != null){
                ptr.next = index1;
            }
            else if(index2 != null){
                ptr.next = index2;
            }
            return dummy.next;
        }
    }

    class Solution {

        class Status implements Comparable<Status>{
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr){
                this.val = val;
                this.ptr = ptr;
            }

            @Override
            public int compareTo(Status status) {
                return this.val - status.val;
            }
        }

        PriorityQueue<Status> record = new PriorityQueue<>();

        public ListNode mergeKLists(ListNode[] lists) {
            for(ListNode list : lists){
                if(list != null){
                    record.offer(new Status(list.val, list));
                }
            }
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while(! record.isEmpty()){
                Status first = record.poll();
                tail.next = first.ptr;
                tail = tail.next;
                if(first.ptr.next != null){
                    record.offer(new Status(first.ptr.next.val,
                                            first.ptr.next));
                }
            }
            return dummy.next;
        }

    }

}

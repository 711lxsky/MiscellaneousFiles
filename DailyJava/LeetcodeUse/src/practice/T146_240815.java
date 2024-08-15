package practice;

import java.util.HashMap;
import java.util.Map;

public class T146_240815 {

    class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;
        DListNode(){};
        DListNode(int key, int val){
            this.val = val;
            this.key = key;
        }
        DListNode(int key, int val, DListNode prev, DListNode next){
            this.val = val;
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }

    class LRUCache {

        int capacity;
        DListNode head;
        DListNode tail;
        Map<Integer, DListNode> record;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new DListNode(-1, 0);
            this.tail = new DListNode(-2, 0);
            head.next = tail;
            tail.prev = head;
            this.record = new HashMap<>();
        }

        public int get(int key) {
            DListNode tarDNode = this.record.get(key);
            if(tarDNode == null){
                return -1;
            }
            int tarVal = tarDNode.val;
            deleteNode(tarDNode);
            moveToHead(tarDNode);
            return tarVal;
        }

        public void put(int key, int value) {
            DListNode node = record.get(key);
            if(node != null){
                node.val = value;
                deleteNode(node);
            }
            else {
                if(record.size() == capacity){
                    DListNode lastNode = removeTail();
                    record.remove(lastNode.key);
                }
                node = new DListNode(key, value);
                record.put(key, node);
            }
            moveToHead(node);
        }

        public DListNode removeTail(){
            DListNode node = tail.prev;
            deleteNode(node);
            return node;
        }

        public void deleteNode(DListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void moveToHead(DListNode node){
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }
    }

}

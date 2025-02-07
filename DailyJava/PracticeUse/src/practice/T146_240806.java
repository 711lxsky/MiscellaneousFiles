package practice;

import java.util.HashMap;
import java.util.Map;

public class T146_240806 {

    class DListNode {
        public int key;
        public int val;
        public DListNode prev;
        public DListNode next;

        public DListNode(){};
        public DListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
        public DListNode(int val, DListNode next, DListNode prev){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 使用双链表 + 哈希表
     */
    class LRUCache {

        private int capacity;
        private Map<Integer, DListNode> record;
        private DListNode head;
        private DListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.record = new HashMap<>();
            this.head = new DListNode(-1, 0);
            this.tail = new DListNode(-2, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(! record.containsKey(key)){
                return -1;
            }
            DListNode tarDNode = record.get(key);
            this.moveDNodeToHead(tarDNode);
            return tarDNode.val;
        }

        public void put(int key, int value) {
            if(record.containsKey(key)){
                DListNode node = record.get(key);
                node.val = value;
                moveDNodeToHead(node);
                return;
            }
            if(record.size() == this.capacity){
                deleteLastDNode();
            }
            DListNode newNode = new DListNode(key, value);
            insertToHead(newNode);
            record.put(key, newNode);
        }

        public void moveDNodeToHead(DListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void deleteLastDNode(){
            int key = tail.prev.key;
            record.remove(key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }

        public void insertToHead(DListNode DNode){
            DNode.next = head.next;
            head.next.prev = DNode;
            head.next = DNode;
            DNode.prev = head;
        }
    }

}

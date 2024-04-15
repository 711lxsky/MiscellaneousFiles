class DoubleLinkedListNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.record = dict()
        self.head = DoubleLinkedListNode()
        self.tail = DoubleLinkedListNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0


    def get(self, key: int) -> int:
        if key not in self.record:
            return -1
        node = self.record[key]
        self.moveNodeToHead(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key not in self.record:
            new_node = DoubleLinkedListNode(key, value)
            self.record[key] = new_node
            self.addNodeToHead(new_node)
            self.size += 1
            if self.size > self.capacity:
                tail_key = self.removeTail()
                self.size -= 1
                self.record.pop(tail_key)
        else:
            node = self.record[key]
            node.value = value
            self.moveNodeToHead(node)


    def addNodeToHead(self, node : DoubleLinkedListNode) -> None:
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def removeNode(self, node : DoubleLinkedListNode) -> None:
        node.prev.next = node.next
        node.next.prev = node.prev

    def moveNodeToHead(self, node : DoubleLinkedListNode) -> None:
        self.removeNode(node)
        self.addNodeToHead(node)
    
    def removeTail(self) -> int:
        node = self.tail.prev
        self.removeNode(node)
        return node.key
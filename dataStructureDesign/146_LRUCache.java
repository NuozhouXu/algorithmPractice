class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        
        public DLinkedNode () {}
        
        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public void addNode(DLinkedNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail() {
        DLinkedNode node = dummyTail.prev;
        removeNode(node);
        return node;
    }
    
    private HashMap<Integer, DLinkedNode> map;
    private int size;
    private int capacity;
    private DLinkedNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new DLinkedNode();
        this.dummyTail = new DLinkedNode();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addNode(node);
            
            size++;
            if (size > capacity) {
                DLinkedNode deletedNode = popTail();
                map.remove(deletedNode.key);
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
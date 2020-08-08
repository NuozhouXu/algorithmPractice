class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node() {}
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public void addNode(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    private Node popTail() {
        if (size > 0) {
            Node node = dummyTail.prev;
            removeNode(node);
            return node;
        } else {
            return null;
        }
    }
    
    private HashMap<Integer, Node> map;
    private int size;
    private int capacity;
    private Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (size == capacity) {
                Node deletedNode = popTail();
                map.remove(deletedNode.key);
                size--;
            }
            
            Node node = new Node(key, value);
            map.put(key, node);
            addNode(node);
            
            size++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node {
    public int key;
    public int val;
    public int count;
    public Node prev;
    public Node next;
    
    public Node() {
        this.count = 1;
    }
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.count = 1;
    }
}

class DLList {
    public Node dummyHead;
    public Node dummyTail;
    public int size;
    
    public DLList() {
        this.size = 0;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void add(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node pop() {
        if (size > 0) {
            Node node = dummyTail.prev;
            remove(node);
            return node;
        } else {
            return null;
        }
    }
}

class LFUCache {
    
    private int capacity;
    private int size;
    private int minFreq;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DLList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.size = 0;
        this.nodeMap = new HashMap<>();
        this.countMap = new HashMap<>();
    }
    
    // O(1)
    public int get(int key) {
        if (capacity == 0) return -1;
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }
    
    // O(1)
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            if (size == capacity) {
                DLList leastFreqLst = countMap.get(minFreq);
                nodeMap.remove(leastFreqLst.pop().key);
                size--;
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            size++;
            minFreq = 1;
            
            DLList newList = countMap.getOrDefault(1, new DLList());
            newList.add(newNode);
            countMap.put(1, newList);
        }
        
    }
    
    private void update(Node node) {
        DLList oldList = countMap.get(node.count);
        oldList.remove(node);
        if (node.count == minFreq && oldList.size == 0) minFreq++;
        node.count++;
        DLList newList = countMap.getOrDefault(node.count, new DLList());
        newList.add(node);
        countMap.put(node.count, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
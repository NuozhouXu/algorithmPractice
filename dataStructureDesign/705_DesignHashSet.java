class Bucket {
    private LinkedList<Integer> lst;
    
    public Bucket() {
        this.lst = new LinkedList<>();
    }
    
    public void add(Integer key) {
        int index = lst.indexOf(key);
        if (index == -1) {
          lst.addFirst(key);
        }
    }
    
    public void remove(Integer key) {
        lst.remove(key);
    }
    
    public boolean contains(Integer key) {
        int index = lst.indexOf(key);
        return index != -1;
    }
}

class MyHashSet {
    
    private Bucket[] buckets;
    private int size;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.size = 769;
        this.buckets = new Bucket[769];
        for (int i = 0; i < size; i++) {
            this.buckets[i] = new Bucket();
        }
    }
    
    private int hash(int key) {
        return (key % size);
    }
    
    // O(N / k) N is all the number space, k is number of buckets
    public void add(int key) {
        int index = hash(key);
        buckets[index].add(key); 
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(key); 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
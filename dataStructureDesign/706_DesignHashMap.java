class Pair {
    public int key;
    public int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private LinkedList<Pair> lst;
    
    public Bucket() {
        this.lst = new LinkedList<>();
    }
    
    public void update(int key, int value) {
        boolean found = false;
        for (Pair pair: lst) {
            if (pair.key == key) {
                found = true;
                pair.value = value;
                break;
            }
        }
        if (!found) {
            lst.add(new Pair(key, value));
        }
    }
    
    public void remove(int key) {
        for (Pair pair: lst) {
            if (pair.key == key) {
                lst.remove(pair);
                break;
            }
        }
    }
    
    public int get(int key) {
        for (Pair pair: lst) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
}

class MyHashMap {
    
    private Bucket[] buckets;
    private int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.buckets = new Bucket[769];
        this.size = 769;
        for (int i = 0; i < size; i++) {
            buckets[i] = new Bucket();
        }
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        buckets[index].update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        return buckets[index].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
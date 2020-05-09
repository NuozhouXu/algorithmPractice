class RandomizedSet {
    
    private Map<Integer, Integer> dict;
    private List<Integer> list;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.dict = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (dict.containsKey(val)) {
            int lastElement = list.get(list.size() - 1);
            int index = dict.get(val);
            list.set(index, lastElement);
            list.remove(list.size() - 1);
            dict.put(lastElement, index);
            dict.remove(val);
            return true;
        }
        
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
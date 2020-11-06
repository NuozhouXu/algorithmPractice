class RandomizedCollection {
    
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1 ? true : false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> currSet = map.get(val);
            int indexToBeReplaced = currSet.iterator().next();
            
            int lastNum = list.get(list.size() - 1);
            Set<Integer> lastNumSet = map.get(lastNum);
            
            list.set(indexToBeReplaced, lastNum);
            currSet.remove(indexToBeReplaced);
            
            if (indexToBeReplaced != list.size() - 1) { 
                lastNumSet.remove(list.size() - 1);
                lastNumSet.add(indexToBeReplaced);
            }
            
            list.remove(list.size() - 1);
            
            if (currSet.size() == 0) {
                map.remove(val);
            }
            return true;
        }
        
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
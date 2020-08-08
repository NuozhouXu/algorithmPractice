class TimeMap {
    // O(n) space
    Map<String, List<Pair<Integer, String>>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    // O(1) time
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    // O(logn) time
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }
    
    // 1 2 3 4
    //               
    private String binarySearch(List<Pair<Integer, String>> lst, int timestamp) {
        int l = 0;
        int r = lst.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (lst.get(mid).getKey() > timestamp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r == 0 ? "" : lst.get(r - 1).getValue();
    }

    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap2() {
        this.map = new HashMap<>();
    }
    
    public void set2(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get2(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        TreeMap<Integer, String> tree = map.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
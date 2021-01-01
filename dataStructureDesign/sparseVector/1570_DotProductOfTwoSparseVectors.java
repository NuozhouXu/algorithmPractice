class SparseVector {
    
    private Map<Integer, Integer> vectorMap;
    
    public Map<Integer, Integer> getVectorMap() {
        return vectorMap;
    }
    
    SparseVector(int[] nums) {
        this.vectorMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.vectorMap.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> otherMap = vec.getVectorMap();
        int result = 0;
        for (int index: this.vectorMap.keySet()) {
            if (otherMap.containsKey(index)) {
                result += this.vectorMap.get(index) * otherMap.get(index);
            }
        }
        return result;
    }
}
class WordDistance {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            this.map.putIfAbsent(words[i], new ArrayList<>());
            this.map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        List<Integer> lst1 = map.get(word1);
        List<Integer> lst2 = map.get(word2);
        while (i < lst1.size() && j < lst2.size()) {
            minDist = Math.min(minDist, Math.abs(lst1.get(i) - lst2.get(j)));
            if (lst1.get(i) < lst2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return minDist;
    }
}
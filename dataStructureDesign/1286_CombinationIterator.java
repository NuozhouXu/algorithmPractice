class CombinationIterator {
    
    Deque<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        this.queue = new ArrayDeque<>();
        combinations(characters, 0, combinationLength, new StringBuilder());
    }
    // O(num of combinations)
    private void combinations(String characters, int index, int combinationLength, StringBuilder sb) {
        if (sb.length() == combinationLength) {
            queue.offer(sb.toString());
            return;
        }
        for (int i = index; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            combinations(characters, i + 1, combinationLength, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    // O(1)
    public String next() {
        return queue.poll();
    }
    
    // O(1)
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
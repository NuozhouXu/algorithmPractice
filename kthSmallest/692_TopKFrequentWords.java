class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            if (count.get(a) > count.get(b)) {
                return 1;
            } else if (count.get(a) < count.get(b)) {
                return -1;
            } else {
                return b.compareTo(a);
            }
        });
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        LinkedList<String> results = new LinkedList<>();
        while (!heap.isEmpty()) {
            results.addFirst(heap.poll());
        }
        return results;
    }
}
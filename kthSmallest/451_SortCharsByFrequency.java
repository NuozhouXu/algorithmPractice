class Solution {
    public String frequencySort(String s) {
        // O(n) space 
        HashMap<Character, Integer> count = new HashMap<>();
        // O(n) space
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        // O(n) time
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        // O(nlogn) time
        for (char c: count.keySet()) {
            heap.offer(c);
        }
        char[] results = new char[s.length()];
        int i = 0;
        // O(nlogn) time
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int j = 0; j < count.get(c); j++) {
                results[i++] = c;
            }
        }
        return new String(results);
    }
}
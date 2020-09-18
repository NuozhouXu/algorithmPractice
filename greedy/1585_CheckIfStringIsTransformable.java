class Solution {
    // O(N) time 
    public boolean isTransformable(String s, String t) {
        List<Deque<Integer>> idx = new ArrayList<>();
        for (int i = 0; i < 10; i++) idx.add(new ArrayDeque<>());
        for (int i = 0; i < s.length(); i++) idx.get(s.charAt(i) - '0').offer(i);
        for (char c: t.toCharArray()) {
            int d = c - '0';
            if (idx.get(d).isEmpty()) return false;
            for (int i = 0; i < d; i++) {
                if (!idx.get(i).isEmpty() && idx.get(i).peek() < idx.get(d).peek()) {
                    return false;
                }
            }
            idx.get(d).poll();
        }
        return true;
    }
}
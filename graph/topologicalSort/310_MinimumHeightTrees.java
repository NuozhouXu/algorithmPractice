class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return n == 0 ? new ArrayList<>() : Arrays.asList(0);
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) queue.add(i);
        }
        
        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}
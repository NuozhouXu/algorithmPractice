class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) return pid;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            graph.putIfAbsent(ppid.get(i), new ArrayList<>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> results = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            results.add(node);
            for (int neighbor: graph.getOrDefault(node, new ArrayList<>())) {
                queue.offer(neighbor);
            }
        }
        return results;
    }
}
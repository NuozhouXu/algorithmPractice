class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        List<List<int[]>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        dist[K] = 0;
        pq.offer(new int[]{K, 0});
        
        while (!pq.isEmpty()) {
            int[] n = pq.poll();
            int node = n[0];
            int time = n[1];
            if (time > dist[node]) continue;
            for (int[] edge: graph.get(node)) {
                int neighbor = edge[0];
                if (time + edge[1] < dist[neighbor]) {
                    dist[neighbor] = time + edge[1];
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public int networkDelayTimeBellmenFord(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        
        for (int i = 1; i < N; i++) {
            for (int[] edge: times) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
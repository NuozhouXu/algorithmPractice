class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue; // If node is already colored, we should skip it
            // The graph might be disconnected, so we need to start bfs with each unvisited node
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor: graph[node]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[node];
                        queue.offer(neighbor);
                    } else if (color[neighbor] != -color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] color, int node, int currColor) {
        color[node] = currColor;
        for (int neighbor: graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(graph, color, neighbor, -currColor)) return false;
            } else if (color[neighbor] != -color[node]) {
                return false;
            }
        }
        return true;
    }
}
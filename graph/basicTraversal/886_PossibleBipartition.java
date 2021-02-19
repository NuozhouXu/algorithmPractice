class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] dislike: dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] colors, int node, int currColor) {
        colors[node] = currColor;
        for (int neighbor: graph.get(node)) {
            if (colors[neighbor] == 0) {
                if (!dfs(graph, colors, neighbor, -currColor)) {
                    return false;
                }
            } else if (colors[neighbor] != -currColor) {
                return false;
            }
        }
        return true;
    }
}
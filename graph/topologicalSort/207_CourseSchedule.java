class Solution {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            colors[i] = WHITE;
        }
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == WHITE) {
                dfs(graph, colors, i);
            }
            if (hasCycle) return false;
        }
        return !hasCycle;
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, int[] colors, int course) {
        if (hasCycle) return;
        colors[course] = GRAY;
        for (int neighbor: graph.get(course)) {
            if (colors[neighbor] == WHITE) {
                dfs(graph, colors, neighbor);
            } else if (colors[neighbor] == GRAY) {
                hasCycle = true;
                return;
            }
        }
        colors[course] = BLACK;
    }
}
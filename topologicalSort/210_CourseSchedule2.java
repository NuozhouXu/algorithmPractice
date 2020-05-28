class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    private boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courseGraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] colors = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            colors[i] = WHITE;
        }
        LinkedList<Integer> topologicalOrder = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == WHITE) {
                dfs(courseGraph, i, colors, topologicalOrder);
            }
        }
        if (hasCycle) return new int[0];
        int[] results = new int[numCourses];
        for (int i = 0; i < topologicalOrder.size(); i++) {
            results[i] = topologicalOrder.get(i);
        }
        return results;
    }
    
    private void dfs(HashMap<Integer, List<Integer>> graph, int course, int[] colors, LinkedList<Integer> topologicalOrder) {
        if (hasCycle) {
          return;
        }
        colors[course] = GRAY;
        for (Integer neighbor: graph.get(course)) {
            if (colors[neighbor] == WHITE) {
                dfs(graph, neighbor, colors, topologicalOrder);
            } else if (colors[neighbor] == GRAY) {
                hasCycle = true;
            }
        }
        colors[course] = BLACK;
        topologicalOrder.addFirst(course);
    }
}